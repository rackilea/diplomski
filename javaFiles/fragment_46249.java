final AtomicReference<String> valueHolder = new AtomicReference<String>();
...
Foo foo = new Foo() {
    @Override public void bar() {
        valueHolder.set("Set in bar");
    }
}