package de.scrum_master.app;

public class Normal extends NormalBase {
    @Override
    public void doSomething() {
        //System.out.println("Doing something normal");
    }

    @Override
    public String sayHelloTo(String name) {
        return "A normal hello to " + name;
    }

    public void doNothing() {
        //System.out.println("Being lazy in a normal way");
    }
}