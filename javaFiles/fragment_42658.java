package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        BlahService bean1 = ac.getBean(BlahService.class);
        System.out.println(bean1.getName());

        BlahService bean2 = ac.getBean(BlahService.class);
        System.out.println(bean2.getName());

        FooService bean3 = ac.getBean(FooService.class);
        bean3.print();
    }
}