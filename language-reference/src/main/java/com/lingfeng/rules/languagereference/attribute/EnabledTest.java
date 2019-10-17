package com.lingfeng.rules.languagereference.attribute;

import com.lingfeng.rules.languagereference.entity.Message;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-17
 */
public class EnabledTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        Message message=new Message();
        message.setMessage("enabled");
        kieSession.insert(message);
        int count=kieSession.fireAllRules();
        System.out.println("enabled 一共执行了"+count+"条规则");
        kieSession.dispose();
    }
}
