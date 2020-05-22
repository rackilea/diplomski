package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        new Parent().doSomething();
        new PlainChild().doSomething();
        new PlainChild().doSomethingElse();
        new AnnotatedChild().doSomething();
        new AnnotatedChild().doSomethingSpecial(123);
    }
}