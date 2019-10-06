package com.lingfeng.rules.languagereference.function;

import com.lingfeng.rules.languagereference.entity.Function;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-06
 */
public class FunctionTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        // 开始执行function
        Function function=new Function();
        function.setIfFunction(true);

        kieSession.insert(function);

        int count=kieSession.fireAllRules();
        System.out.println("这次执行了"+count+"规则");
        kieSession.dispose();
    }
}
