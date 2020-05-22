class Foo {
    void bar() {
        // stuff that requires being in an instance, such as...
        System.out.println(this.getClass());
    }

    public static void main(String... args) {
        (new Foo()).bar();
    }
}