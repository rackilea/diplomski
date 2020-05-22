interface Nested {
    Object getFoo();
}

static Nested newNested(Object foo) {
    // NestedImpl has method scope,
    // so the outer class can't refer to it by name
    // e.g. even to cast to it
    class NestedImpl implements Nested {
        Object foo;

        NestedImpl(Object foo) {
            this.foo = foo;
        }

        @Override
        public Object getFoo() {
            return foo;
        }
    }

    return new NestedImpl(foo);
}