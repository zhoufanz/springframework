package test.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * Created by zf on 2017-03-20.
 */
public class EmitLog {
    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.174.128");
        factory.setUsername("zf");
        factory.setPassword("zf");
        Connection connection = factory.newConnection();
        Channel channel=connection.createChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        for (int i = 0; i < 5; i++) {
            String message="Hello World"+i;
            channel.basicPublish(EXCHANGE_NAME,"1",null,message.getBytes());
            System.out.println("EmitLog Sent '"+message+"'");
        }
        channel.close();
        connection.close();
    }
}
