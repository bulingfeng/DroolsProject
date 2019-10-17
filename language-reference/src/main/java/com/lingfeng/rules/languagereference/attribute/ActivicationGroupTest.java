package com.lingfeng.rules.languagereference.attribute;

import com.lingfeng.rules.languagereference.entity.Message;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-17
 */
public class ActivicationGroupTest {
    public static void main(String[] args) {
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("rulesSession");
        kSession.getAgenda().getActivationGroup("activicationGroup-1");
        Message message=new Message();
        message.setMessage("ActivicationGroup");
        kSession.insert(message);
        int count=kSession.fireAllRules();
        System.out.println("enabled 一共执行了"+count+"条规则");
        kSession.dispose();
    }
}
