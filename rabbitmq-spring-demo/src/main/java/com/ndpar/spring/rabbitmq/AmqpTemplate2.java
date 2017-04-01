package com.ndpar.spring.rabbitmq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;

/**
 * Created by zf on 2017-03-14.
 */
public class AmqpTemplate2 implements AmqpTemplate {
    @Override
    public void send(Message message) throws AmqpException {

    }

    @Override
    public void send(String s, Message message) throws AmqpException {

    }

    @Override
    public void send(String s, String s1, Message message) throws AmqpException {

    }

    @Override
    public void convertAndSend(Object o) throws AmqpException {

    }

    @Override
    public void convertAndSend(String s, Object o) throws AmqpException {

    }

    @Override
    public void convertAndSend(String s, String s1, Object o) throws AmqpException {

    }

    @Override
    public void convertAndSend(Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {

    }

    @Override
    public void convertAndSend(String s, Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {

    }

    @Override
    public void convertAndSend(String s, String s1, Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {

    }

    @Override
    public Message receive() throws AmqpException {
        return null;
    }

    @Override
    public Message receive(String s) throws AmqpException {
        return null;
    }

    @Override
    public Object receiveAndConvert() throws AmqpException {
        return null;
    }

    @Override
    public Object receiveAndConvert(String s) throws AmqpException {
        return null;
    }

    @Override
    public Message sendAndReceive(Message message) throws AmqpException {
        return null;
    }

    @Override
    public Message sendAndReceive(String s, Message message) throws AmqpException {
        return null;
    }

    @Override
    public Message sendAndReceive(String s, String s1, Message message) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(Object o) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(String s, Object o) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(String s, String s1, Object o) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(String s, Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {
        return null;
    }

    @Override
    public Object convertSendAndReceive(String s, String s1, Object o, MessagePostProcessor messagePostProcessor) throws AmqpException {
        return null;
    }
}
