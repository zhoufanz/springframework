package routing;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by zf on 2017-03-20.
 */
public class ReceiveLogsDirect1 {
    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String[] routingKeys = new String[]{"error"};

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.174.128");
        factory.setUsername("zf");
        factory.setPassword("zf");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        String queueName = "aaaaa";

        //根据路由关键字进行绑定
        for (String routingKey:routingKeys){
            channel.queueBind(queueName,EXCHANGE_NAME,routingKey);
            System.out.println("ReceiveLogsDirect1 exchange:"+EXCHANGE_NAME+"," +
                    " queue:"+queueName+", BindRoutingKey:" + routingKey);
        }
        System.out.println("ReceiveLogsDirect1  Waiting for messages");
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("ReceiveLogsDirect1 Received '" + envelope.getRoutingKey() + "':'" + message + "'");
            }
        };
        channel.basicConsume(queueName, true, consumer);
    }
}
