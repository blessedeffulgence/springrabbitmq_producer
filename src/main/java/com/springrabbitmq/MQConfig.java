package com.springrabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class MQConfig {

//    public static final String MESSAGE_QUEUE = "message_queue";
//    public static final String EXCHANGE = "exchange";
//    public static final String MESSAGE_KEY = "messageKey";
//
//
//    public Queue queue()
//    {
//        return new Queue(MESSAGE_QUEUE);
//    }
//
//
//    public TopicExchange exchange()
//    {
//        return new TopicExchange(EXCHANGE);
//    }
//
//
//    public Binding binding(Queue queue, TopicExchange exchange)
//    {
//        return BindingBuilder.bind(queue)
//                .to(exchange)
//                .with(MESSAGE_KEY);
//    }
//
//
//    public MessageConverter messageConverter()
//    {
//        return new Jackson2JsonMessageConverter();
//    }
//
//
//    public AmqpTemplate template(ConnectionFactory connectionFactory)
//    {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(messageConverter());
//        return template;
//    }
}
