package org.studyspring.beanfactory;

import org.springframework.beans.factory.InitializingBean;


public class HelloWorld1  {
    private String name;

    public void setName(String name) {
        this.name = name;
    }



    public void init() throws Exception {
        System.out.println(this.getClass().getName() +"---------------name = "+name+"--->This is before bean initialized");
    }

    public void destroy() throws Exception {
        System.out.println(this.getClass().getName() +"---------------name = "+name+"--->This is after bean destroyed ");
    }
}