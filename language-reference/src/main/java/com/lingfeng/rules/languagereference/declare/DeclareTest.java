package com.lingfeng.rules.languagereference.declare;

import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-14
 */
public class DeclareTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();


        int count=kieSession.fireAllRules();
        System.out.println("这次执行了"+count+"规则");
        kieSession.dispose();
    }
}
