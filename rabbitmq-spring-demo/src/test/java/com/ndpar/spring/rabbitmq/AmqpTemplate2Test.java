package com.ndpar.spring.rabbitmq;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * AmqpTemplate2 Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>三月 14, 2017</pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
public class AmqpTemplate2Test {
    @Autowired
    private AmqpTemplate at;

    @Test
    public void test() throws InterruptedException {
        while (true){
            
        }
        //Thread.currentThread().wait();
    }
    /**
     * Method: convertAndSend(String s, String s1, Object o)
     */
    @Test
    public void testConvertAndSendForSS1O() throws Exception {
        String msg="sfdfsdfdsfd";
        at.convertAndSend("zf.fonout","zf.queue",msg);
        System.out.println("ok");
       // Thread.currentThread().sleep(2000);
//TODO: Test goes here... 
    }
    @Test
    public void testConvertAndSendForSS1O2() throws Exception {
        String msg="sfdfsdfdsfd";
        at.convertAndSend("zf.topic","zf.topic.sss",msg);
        System.out.println("ok");
        Thread.currentThread().sleep(2000);
//TODO: Test goes here...
    }


} 
