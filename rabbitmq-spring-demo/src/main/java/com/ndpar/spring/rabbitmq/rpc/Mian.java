package com.ndpar.spring.rabbitmq.rpc;

import java.io.IOException;

/**
 * Created by zf on 2017-03-26.
 */
public class Mian {
    public static void main(String[] args) throws IOException, InterruptedException {
        RPCClient rpcClient=new RPCClient();
        rpcClient.call(3+"");
    }
}
