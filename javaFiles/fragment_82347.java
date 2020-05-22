package de.scrum_master.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(basePackages = { "de.scrum_master" })
public class Application2 {
  public static void main(String[] args) throws Exception {
    ApplicationContext appContext = new AnnotationConfigApplicationContext(Application2.class);
    B b = (B) appContext.getBean("b");
    System.out.println(b.getData("bbb"));
    A a = (A) appContext.getBean("b");
    System.out.println(a.getData("aaa"));
  }
}