public static void main(String[] args) {
    //how to use
    checkAndCAll(true, () -> someMethod("param1,", "param2"));
    checkAndCAll(false, () -> anotherMethod("param1", 123));
}

public static void checkAndCAll(boolean b, Runnable action) {
    if (b) action.run();
}

public static void someMethod(Object param1, Object param2) {
    //some method to execute
}

public static void anotherMethod(String param1, Integer param2) {
    //some method to execute
}