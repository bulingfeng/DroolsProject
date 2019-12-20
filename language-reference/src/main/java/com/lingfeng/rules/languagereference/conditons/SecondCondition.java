package com.lingfeng.rules.languagereference.conditons;

import com.lingfeng.rules.languagereference.entity.Person;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-22
 */
public class SecondCondition {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        Person person=new Person();
        person.setAge(22);
        person.setName("小王");

        kieSession.insert(person);

        int count=kieSession.fireAllRules();

        System.out.println("secondCondition执行了"+count+"规则");

        kieSession.dispose();
    }
}
