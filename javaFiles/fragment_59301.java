public interface Interface {
    default void doSomething() {
        InterfaceHelper.doSomething();
    }
}

class InterfaceHelper {
    static void doSomething() { //package-private class and method

    }
}