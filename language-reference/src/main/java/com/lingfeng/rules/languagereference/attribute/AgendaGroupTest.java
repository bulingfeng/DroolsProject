package com.lingfeng.rules.languagereference.attribute;

import com.lingfeng.rules.languagereference.entity.Message;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-17
 */
public class AgendaGroupTest {
    public static void main(String[] args) {
//        String agendGroupName="agendaGroup-1";
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.getKieClasspathContainer();
        KieSession kSession = kContainer.newKieSession("rulesSession");
        kSession.getAgenda().getAgendaGroup("agendaGroup-1").setFocus();
        Message message=new Message();
        message.setMessage("AgendaGroupRule");
        kSession.insert(message);
        int count=kSession.fireAllRules();
        System.out.println("enabled 一共执行了"+count+"条规则");
        kSession.dispose();
    }
}
