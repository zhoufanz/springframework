package com.zf.spring.mybatis;

import com.zf.spring.mybatis.IFieldWiring;
import com.zf.spring.mybatis.ReflectUtils;
import com.zf.spring.mybatis.SqlMapClient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class DataSourceWiring implements IFieldWiring {

    @Override
    public void wiring(Object object, Field field) {
        Object fieldObj = ReflectUtils.getFieldValue(object, field.getName()); // 获得field对应的对象
        if (fieldObj != null) {
            return;
        }
        DataSource annotation = field.getAnnotation(DataSource.class);
        String type = annotation.type();
        String sqlMap = annotation.sqlMap();
        // 这里可以用缓存来实现，不用每次都去创建新的SqlMapClient对象
        SqlMapClient sqlMapImpl = new SqlMapClient(sqlMap, type);
        // 将生成SqlMapClient注入到bean对象的字段上
        ReflectUtils.setFieldValue(object, field.getName(), SqlMapClient.class, sqlMapImpl);
    }

    @Override
    public Class<? extends Annotation> annotationClass() {
        return DataSource.class;
    }
}