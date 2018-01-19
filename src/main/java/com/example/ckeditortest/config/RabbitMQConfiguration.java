package com.example.ckeditortest.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zhuyunpeng on 2018/01/19
 **/
@Configuration
public class RabbitMQConfiguration {


    @Bean
    public TopicExchange createExchange(){
        return new TopicExchange(Constants.EXCHANGE_NAME);
    }

    @Bean
    public Queue createQueue(){
        return new Queue(Constants.QUEUE_NAME);
    }

    @Bean
    public Binding createBinding(TopicExchange exchange,Queue queue) {
        return BindingBuilder.bind(queue).to(exchange).with("*");
    }

    @Bean
    public SimpleMessageListenerContainer createListener(ConnectionFactory connectionFactory, RabbitMQListener listener) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(Constants.QUEUE_NAME);
        container.setMessageListener(listener);
        return container;
    }

}
