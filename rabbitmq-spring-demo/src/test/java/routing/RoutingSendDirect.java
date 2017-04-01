package routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by zf on 2017-03-20.
 */
public class RoutingSendDirect {
    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String[] routingKeys = new String[]{"info", "warning", "error"};

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setPassword("zf");
        factory.setUsername("zf");
        factory.setHost("192.168.174.128");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        for (String routingkey : routingKeys) {
            String message = "RoutingSendDirect Send the message level:" + routingkey;
            System.out.println(message);
            channel.basicPublish(EXCHANGE_NAME,routingkey,null,message.getBytes());
        }
        channel.close();
        connection.close();
    }
}
