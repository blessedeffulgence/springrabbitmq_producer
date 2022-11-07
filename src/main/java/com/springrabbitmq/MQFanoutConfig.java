package com.springrabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class MQFanoutConfig {

//    public static final String FANOUT_QUEUE_ONE = "fanout_queue_one";
//    public static final String FANOUT_QUEUE_TWO = "fanout_queue_two";
//    public static final String FANOUT_QUEUE_THREE = "fanout_queue_three";
//    public static final String FANOUT_EXCHANGE = "fanout_exchange";
//
//    @Bean
//    public Queue queueOne()
//    {
//        return new Queue(FANOUT_QUEUE_ONE);
//    }
//
//    @Bean
//    public Queue queueTwo()
//    {
//        return new Queue(FANOUT_QUEUE_TWO);
//    }
//
//    @Bean
//    public Queue queueThree()
//    {
//        return new Queue(FANOUT_QUEUE_THREE);
//    }
//
//    @Bean
//    public FanoutExchange fanoutExchange()
//    {
//        return new FanoutExchange(FANOUT_EXCHANGE);
//    }
//
//    @Bean
//    public Binding bindingOne(FanoutExchange fanoutExchange, Queue queueOne)
//    {
//      return BindingBuilder.bind(queueOne).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindingTwo(FanoutExchange fanoutExchange, Queue queueTwo)
//    {
//        return BindingBuilder.bind(queueTwo).to(fanoutExchange);
//    }
//
//    @Bean
//    public Binding bindingThree(FanoutExchange fanoutExchange, Queue queueThree)
//    {
//        return BindingBuilder.bind(queueThree).to(fanoutExchange);
//    }
}
