package com.springrabbitmq;

import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class MessagePublisher {

    private final RabbitTemplate rabbitTemplate;
   // private final FanoutExchange fanoutExchange;

    @Autowired
    private DirectExchange directExchange;

    private static final Logger logger = LoggerFactory.getLogger(MessagePublisher.class);

    AtomicInteger index = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    private final String[] keys = {"orange", "black", "green"};

    Faker faker = new Faker();
    public MessagePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;

    }

    @PostMapping("/publish")
    public String publishMessage(@RequestBody CustomMessage customMessage)
    {

        customMessage.setMessageId(1);
        customMessage.setMessageDate(new Date());
      //  rabbitTemplate.convertAndSend(MQConfig.EXCHANGE,MQConfig.MESSAGE_KEY,customMessage);

        return "Message Published";
    }

    public String fanOut()
    {
        CustomMessage message = new CustomMessage();
        message.setMessageId(faker.number().randomDigitNotZero());
        message.setMessageDate(new Date());
        message.setMessage(faker.shakespeare().asYouLikeItQuote());
        //rabbitTemplate.convertAndSend(MQFanoutConfig.FANOUT_EXCHANGE,"",message);
        logger.info("Message: " +message);
        return "Message Published";
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello to ");
        if (this.index.incrementAndGet() == 3) {
            this.index.set(0);
        }
        String key = keys[this.index.get()];
        builder.append(key).append(' ');
        builder.append(this.count.get());
        String message = builder.toString();
        rabbitTemplate.convertAndSend(directExchange.getName(), key, message);
        System.out.println(" [x] Sent '" + message + "'");
    }


}
