package com.lingfeng.rules.languagereference.attribute;

import com.lingfeng.rules.languagereference.entity.Message;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-18
 */
public class DurationTest {
    public static void main(String[] args) throws InterruptedException {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        Message message=new Message("1","duration");

        kieSession.insert(message);
        Thread.sleep(100);
        int count=kieSession.fireAllRules();
        System.out.println("duration 执行了"+count+"条规则");
        kieSession.dispose();
    }
}
