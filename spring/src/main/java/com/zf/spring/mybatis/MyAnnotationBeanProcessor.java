package com.zf.spring.mybatis;

import com.zf.spring.mybatis.IFieldWiring;

import java.lang.reflect.Field;

public class MyAnnotationBeanProcessor {

    /**
     * 注入资源
     *
     * @param serviceObject
     * @param fieldAutoWirings // 所有实现IFieldWiring的接口的对象，我们可以在此扩展
     * @throws Exception
     */
    public void wire(Object serviceObject, IFieldWiring ... fieldAutoWirings)
            throws Exception {
        Class cls = serviceObject.getClass();
        for (Field field : cls.getDeclaredFields()) {
            for (IFieldWiring fieldAutoWiring : fieldAutoWirings)
                if (field.isAnnotationPresent(fieldAutoWiring.annotationClass())) {
                    fieldAutoWiring.wiring(serviceObject, field);
                    break;
                }
        }
    }
}