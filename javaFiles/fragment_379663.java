package org.studyspring.beanfactory    
public class HelloWorld implements InitializingBean {
        private String name;

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public void afterPropertiesSet() throws Exception {
            System.out.println(this.getClass().getName() +"---------------name = "+name+"--->This is after bean initialized ");
        }
    }