package com.lingfeng.rules.languagereference.query;

import com.lingfeng.rules.languagereference.entity.Person;
import com.lingfeng.rules.languagereference.utils.CreatKieSessionUtils;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:bulingfeng
 * @Date: 2019-10-06
 */
public class QueryTest {
    public static void main(String[] args) {
        KieSession kieSession= CreatKieSessionUtils.createKieSession();

        List<Person> personList=new ArrayList<>();

        Person p1=new Person(11,"name11");
        Person p2=new Person(32,"name30");
        // 这里的顺序一定要严格保证
        kieSession.insert(p1);
        kieSession.insert(p2);
        int count=kieSession.fireAllRules();
        System.out.println("query一共执行了"+count+"条规则");
        QueryResults results = kieSession.getQueryResults( "people under the age of 21" );
        System.out.println("这批人中有"+results.size()+"个人，年龄小于21");

        QueryResults over30 = kieSession.getQueryResults( "over30" );
        for ( QueryResultsRow row : over30 ) {
            Person person = (Person)row.get("$person");
            System.out.println( person.getName() + "\n" );
        }
        kieSession.dispose();

    }
}
