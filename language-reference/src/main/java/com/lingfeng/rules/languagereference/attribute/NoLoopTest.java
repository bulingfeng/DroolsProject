package com.lingfeng.rules.languagereference.attribute;

import com.lingfeng.rules.languagereference.entity.NoLoopEntity;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-14
 */
public class NoLoopTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        NoLoopEntity noLoop1=new NoLoopEntity();
        noLoop1.setIsExe(true);

        NoLoopEntity noLoop2=new NoLoopEntity();
        noLoop2.setIsExe(true);

        kieSession.insert(noLoop1);
//        kieSession.insert(noLoop2);
//
//        kieSession.insert(noLoop1); // 如果no-loop为true不会重复执行

        int count=kieSession.fireAllRules();
        System.out.println("这次执行了"+count+"规则");
        kieSession.dispose();
    }
}
