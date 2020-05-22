class Foo {
    void bar() {
        class Baz {
            void hi() {
                System.out.println("Hi");
            }
        }
        Baz baz = new Baz();
        baz.hi();
    }
}