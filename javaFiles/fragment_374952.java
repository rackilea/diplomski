package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        app.say("Hello world!");
        app.add(11, 22);
    }

    private int add(int i, int j) { return i + j; }
    public void say(String message) { System.out.println(message); }
}