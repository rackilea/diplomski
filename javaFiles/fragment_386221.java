package de.scrum_master.app;

import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) throws Exception {
        Method method;
        try {
            method = Foo.class.getDeclaredMethod("sayHelloTo", String.class);
        } catch (NoSuchMethodException nsme) {
            method = null;
        }
        System.out.println("Foo: " + method);

        try {
            method = Bar.class.getDeclaredMethod("sayHelloTo", String.class);
        } catch (NoSuchMethodException nsme) {
            method = null;
        }
        System.out.println("Bar: " + method);

        try {
            method = Zot.class.getDeclaredMethod("sayHelloTo", String.class);
        } catch (NoSuchMethodException nsme) {
            method = null;
        }
        System.out.println("Zot: " + method);
    }
}