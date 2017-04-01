package test.fanout;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by zf on 2017-03-20.
 */
public class ReceiveLogs2 {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException {
        ConnectionFactory connectionFactory=new ConnectionFactory();
        connectionFactory.setHost("192.168.174.128");
        connectionFactory.setUsername("zf");
        connectionFactory.setPassword("zf");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,EXCHANGE_NAME,"2");
        System.out.println("ReceiveLogs1 Waiting for messages");
        Consumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogs1 Received" +message+" ");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
