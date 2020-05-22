package de.scrum_master.app;

public class SpecialTwo extends SpecialBase {
    @Override
    public void doFoo() {
        //System.out.println("Doing foo");
    }

    @Override
    public void makeBar() {
        //System.out.println("Making bar");
    }

    public String doXxx() {
        return "Xxx";
    }

    public int makeBlah() {
        return 22;
    }
}