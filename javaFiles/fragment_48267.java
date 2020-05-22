public void doExample2(Object input) {
    if (input instanceof Integer) {
        System.out.println("I am a number");
    } else if (input instanceof Graphics) {
        System.out.println("I am a Graphics");
    }
}