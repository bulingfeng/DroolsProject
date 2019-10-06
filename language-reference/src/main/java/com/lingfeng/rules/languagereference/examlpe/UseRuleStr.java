package com.lingfeng.rules.languagereference.examlpe;

import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;

import java.io.UnsupportedEncodingException;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-06
 *
 * 有3中方法可以创建出来kieSession
 * 1：KieService和KieContainer来创建，这种适合于读取drl文件
 * 2：通过KnowledgeBuilder和KieBase来创建能够读取drl的字符串
 * 3：可以通过KieHelper来创建，也是可以读取drl的字符串
 *
 *  为什么搞了这么多实现方法，
 *  方法1是为了能够直接读取jar中的drl文件
 *  方法2是能够用来实现excel、drl等文件操作。
 *  方法3目的呢？难道就是为了不让商用？看源码的注释是这么写的
 */
public class UseRuleStr {
    public static void main(String[] args) throws UnsupportedEncodingException {


        /**
         * 方法1
         */
        String myRule1 = "package rules rule \"Hello World 2\" when eval(true) then System.out.println(\"Test, Drools!\"); end";
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kfs = kieServices.newKieFileSystem();
        // 个人认为这个只是吧标识 在内存中的一个标识
        kfs.write("/Users", myRule1.getBytes("UTF-8"));
        System.out.println("从路径里面读取的数据为"+new String(kfs.read("/Users")));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kfs).buildAll();
        if (kieBuilder.getResults().getMessages(Message.Level.ERROR).size() > 0) {
            throw new RuntimeException(kieBuilder.getResults().getMessages().toString());
        }
        KieContainer kieContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
        KieBase kBase = kieContainer.getKieBase();
        KieSession kieSession11 = kBase.newKieSession();
        kieSession11.fireAllRules();

        /**
         * 方法2
         */
//        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
//        List<String> drls=new ArrayList<>();
//        drls.add("package rules rule \"Hello World 2\" when eval(true) then System.out.println(\"Test, Drools!\"); end");
//        for (String drl : drls) {
//            knowledgeBuilder.add(new ByteArrayResource(drl.getBytes(StandardCharsets.UTF_8)), ResourceType.DRL);
//        }
//        KieBase kieBase = knowledgeBuilder.newKieBase();
//        KieSession kieSession = kieBase.newKieSession();
//        kieSession.fireAllRules();
//        kieSession.dispose();
//
//        /**
//         * 方法3
//         */
//        String myRule = "package rules rule \"Hello World 2\" when eval(true) then System.out.println(\"Test, Drools!\"); end";
//
//        System.out.println(myRule);
//
        KieHelper helper = new KieHelper();
//
//        helper.addContent(myRule, ResourceType.DRL);
//        KieSession ksession = helper.build().newKieSession();
//
//        int i = ksession.fireAllRules(); ksession.dispose();



    }
}
