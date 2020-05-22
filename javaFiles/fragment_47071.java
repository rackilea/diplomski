@Command(name = "hello")
class Hello implements Runnable {
    public static void main(String[] args) {
        CommandLine.run(new Hello(), args);
    }
    public void run() { System.out.println("hello"); }
}

@Command(name = "bye")
class Bye implements Runnable {
    public static void main(String[] args) {
        CommandLine.run(new Bye(), args);
    }
    public void run() { System.out.println("bye"); }
}