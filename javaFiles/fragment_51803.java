class B {
    C obj_c = new C();

    public void method_b(String... args) {
        List<String> names = Arrays.asList(args);
        String qwerty = "Hello " + obj_c.method_c(names);
    }
}