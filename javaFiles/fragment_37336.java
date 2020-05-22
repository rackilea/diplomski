interface Animal {
    default void saySomething() {
        System.out.println("Something");
    }
}

interface Cat {
    default void saySomething() {
        System.out.println("Meow");
    }
}

class Tiger implements Animal, Cat {
    // Restricted
}