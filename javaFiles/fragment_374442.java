package de.scrum_master.app;

public class Special extends SpecialBase implements MyInterface {
    @Override
    public void doSomething() {
        //System.out.println("Doing something special");
    }

    @Override
    public int doSomethingElse(int a, int b) {
        return a * b;
    }

    @Override
    public String sayHelloTo(String name) {
        return "A special hello to " + name;
    }

    @Override
    public void doFoo() {
        //System.out.println("Doing foo");
    }

    @Override
    public void makeBar() {
        //System.out.println("Making bar");
    }

    public int doZot() {
        return 11;
    }

    public String makeBlah() {
        return "Blah";
    }
}