package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        System.out.println("Normal instance");
        Normal normal = new Normal();
        normal.doSomething();
        normal.doSomethingElse(3, 5);
        normal.sayHelloTo("John");
        normal.doNothing();

        System.out.println("\nNormal instance as NormalBase");
        NormalBase normalBase = normal;
        normalBase.doSomething();
        normalBase.doSomethingElse(3, 5);
        normalBase.sayHelloTo("John");

        System.out.println("\nNormal instance as MyInterface");
        MyInterface myInterface = normal;
        myInterface.doSomething();
        myInterface.doSomethingElse(3, 5);
        myInterface.sayHelloTo("John");

        System.out.println("\nSpecial instance");
        Special special = new Special();
        special.doSomething();
        special.doSomethingElse(7, 8);
        special.doFoo();
        special.doZot();
        special.makeBar();
        special.makeBlah();
        special.sayHelloTo("Jane");

        System.out.println("\nSpecial instance as SpecialBase");
        SpecialBase specialBase = special;
        specialBase.doFoo();
        specialBase.makeBar();

        System.out.println("\nSpecial instance as MyInterface");
        myInterface = special;
        myInterface.doSomething();
        myInterface.doSomethingElse(7, 8);
        myInterface.sayHelloTo("Jane");

        System.out.println("\nSpecialTwo instance");
        SpecialTwo specialTwo = new SpecialTwo();
        specialTwo.doFoo();
        specialTwo.makeBar();
        specialTwo.makeBlah();
        specialTwo.doXxx();

        System.out.println("\nSpecialTwo instance as SpecialBase");
        specialBase = specialTwo;
        specialBase.doFoo();
        specialBase.makeBar();
    }
}