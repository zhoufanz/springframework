package com.zf.spring.mybatis;

import com.zf.spring.mybatis.MyAnnotationBeanProcessor;
import com.zf.spring.mybatis.MyService;

public class FieldWiringTest {
    public static void main(String args[]) throws Exception {
        MyAnnotationBeanProcessor processor = new MyAnnotationBeanProcessor();

        MyService b = new MyService();

        processor.wire(b, new DataSourceWiring()); // 注入DataSource资源

        System.out.println(b.selectForObjectFromB("", null));
        System.out.println(b.selectForObjectFromA("", null));
    }
}