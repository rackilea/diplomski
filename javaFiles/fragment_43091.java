package org.myDomain.app;

public class Application {
    public  static void sayHelloTo(String counterpart) {
        Utils.printToConsole("Hello " + counterpart + "!");
    }

    public static void main(String[] args) {
        sayHelloTo("world");
    }
}