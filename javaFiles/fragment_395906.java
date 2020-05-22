package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring.xml");
        MyService ms = ac.getBean(MyService.class);
        try {
            ms.throw1();
        } catch (Exception e) {
//          e.printStackTrace();
        }
        try {
            ms.throw2();
        } catch (Exception e) {
//          e.printStackTrace();
        }
    }
}