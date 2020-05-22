interface Function {
    void run();
}

static void example(Function f) {
    f.run();
}

void runExample() {
    final int a = 10;
    example(new Function() {
        void run() {
            // Notice that "a" was defined in the outer scope
            System.out.println(a);
        }
    });
}