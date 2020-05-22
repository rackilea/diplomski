interface Something {
    void doSomething();
}

class HelloWorld {
    void doSomething() {
        System.out.println("Hello world");
    }
}

class Main {

    void runFunc(Something s) {
        s.doSomething();
    }

    public static void main(String... args) {
        runFunc(new HelloWorld());
    }

}