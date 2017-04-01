package com.zf.spring.mybatis;

import java.lang.annotation.Annotation;
        import java.lang.reflect.Field;

public interface IFieldWiring {

    Class<? extends Annotation> annotationClass();

    void wiring(Object object, Field field);
}