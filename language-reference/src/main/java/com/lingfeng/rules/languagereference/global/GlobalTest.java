package com.lingfeng.rules.languagereference.global;

import com.alibaba.fastjson.JSON;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-14
 */
public class GlobalTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        List<String> list = new ArrayList<>();
        kieSession.setGlobal( "myGlobalList", list );

        kieSession.insert(list);
        kieSession.fireAllRules();

        kieSession.dispose();
        System.out.println("全局变量:"+ JSON.toJSONString(list));
    }

}
