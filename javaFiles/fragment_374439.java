package de.scrum_master.app;

public abstract class NormalBase implements MyInterface {
    @Override
    public abstract void doSomething();

    @Override
    public int doSomethingElse(int a, int b) {
        return a + b;
    }

    @Override
    public abstract String sayHelloTo(String name);
}