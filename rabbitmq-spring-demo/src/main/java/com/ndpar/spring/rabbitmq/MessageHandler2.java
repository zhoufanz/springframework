package com.ndpar.spring.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

public class MessageHandler2 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("Received message2: " + message);
        System.out.println("Text2: " + new String(message.getBody()));
    }
}
