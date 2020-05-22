class Outer {
    static class Foo {
        private Foo() {}
        private int i;
    }
    static class Bar {{
        // Bar has access to Foo's
        // private members too
        new Foo().i = 2;
    }}
}