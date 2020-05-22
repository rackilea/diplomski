package com.study.test;
public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(Class.forName("com.study.test.HelloWorld")
            .getClassLoader());
    }
}