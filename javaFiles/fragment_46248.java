final String[] valueHolder = new String[1];
...
Foo foo = new Foo() {
    @Override public void bar() {
        valueHolder[0] = "Set in bar";
    }
}