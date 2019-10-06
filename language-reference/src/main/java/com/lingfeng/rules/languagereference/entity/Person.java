package com.lingfeng.rules.languagereference.entity;

import lombok.Data;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-06
 */
@Data
public class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }
}
