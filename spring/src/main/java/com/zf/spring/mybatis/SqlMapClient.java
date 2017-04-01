package com.zf.spring.mybatis;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@SuppressWarnings("unchecked")
public class SqlMapClient {
    public SqlMapClient(String s, String t) {
        sqlMap = s;
        type = t;
    }

    public SqlMapClient() {
    }

    private String type   = null;

    private String sqlMap = null;
    // get、set方法 略

    // 用于演示查询后返回一个String的返回结果
    public String selectForObject(String sql, Map in) {
        return this.toString();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).append("sqlMap", sqlMap)
                .append("type", type).toString();
    }
}