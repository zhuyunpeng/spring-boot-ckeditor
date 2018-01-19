package com.example.ckeditortest.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by zhuyunpeng on 2018/01/19
 **/
@Component
public class RabbitMQListener implements MessageListener {

    ObjectReader objectReader;

    @Autowired
    public RabbitMQListener(ObjectMapper objectMapper) {
        objectReader = objectMapper.readerFor(Event.class);
    }

    @Override
    public void onMessage(Message message) {
        String receivedRoutingKey = message.getMessageProperties().getReceivedRoutingKey();
        System.out.println("receivedRoutingKey:" + receivedRoutingKey);
        try {
            Event receivedMessage = objectReader.readValue(message.getBody());
            System.out.println("Name from RecievedMessage is  :: " + receivedMessage.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
