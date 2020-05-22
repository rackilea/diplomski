void func1() {
    try {
        func2();
        if (someString.equals("some value") {
            someOtherFunction();
        }
    } catch (NullPointerException e) {
        // handle func2()'s NPE somehow
    }

}