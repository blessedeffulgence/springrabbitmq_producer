package com.springrabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MQDirectConfig {


    @Bean
    public Queue directQueueOne() {
        return new Queue("direct_queue_one");
    }

    @Bean
    public Queue directQueueTwo() {
        return new Queue("direct_queue_two");
    }

    @Bean
    public DirectExchange direct() {
        return new DirectExchange("tut.direct");
    }

    @Bean
    public Binding binding1a(DirectExchange direct,
                             Queue directQueueOne) {
        return BindingBuilder.bind(directQueueOne)
                .to(direct)
                .with("orange");
    }

    @Bean
    public Binding binding1b(DirectExchange direct,
                             Queue directQueueOne) {
        return BindingBuilder.bind(directQueueOne)
                .to(direct)
                .with("black");
    }

    @Bean
    public Binding binding2a(DirectExchange direct,
                             Queue directQueueTwo) {
        return BindingBuilder.bind(directQueueTwo)
                .to(direct)
                .with("green");
    }

    @Bean
    public Binding binding2b(DirectExchange direct,
                             Queue directQueueTwo) {
        return BindingBuilder.bind(directQueueTwo)
                .to(direct)
                .with("black");
    }


    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
