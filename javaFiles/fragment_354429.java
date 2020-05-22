class Parent {
    protected int neededByFoo;
    protected int neededByBar;

    class FooA implements Foo {
        public void foo() {
            doStuffWithNeededByFoo();
        }
    }
    class FooB implements Foo {
        public void foo() {
            doStuffWithNeededByFoo();
        }
    }
    // same for the BarA and BarB implementations
}