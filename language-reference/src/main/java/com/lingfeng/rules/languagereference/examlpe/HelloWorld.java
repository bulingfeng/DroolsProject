package com.lingfeng.rules.languagereference.examlpe;

import com.lingfeng.rules.languagereference.entity.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-04
 */
public class HelloWorld {
    public static void main(String[] args) {
        // 获取无状态的KieSession
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("rulesSession");

        // 执行规则
        Message message = new Message();
        message.setMessage("Hello World");
        message.setStatus("hi");
        kSession.insert(message);//插入
        kSession.fireAllRules();//执行规则
        kSession.dispose();

        System.out.println(message.getMessage());
    }
}
