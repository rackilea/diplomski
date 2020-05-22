private static class FooBarDelegate implements FooBar {
        Foo fooDelegate;
        Bar barDelegate;
        private FooBarDelegate(Foo f, Bar b) { fooDelegate = f; barDelegate = b; }
        public void foo() { fooDelegate.foo(); }
        public void bar() { barDelegate.bar(); }
    }

    public FooBar fooAbarA() {
        return new FooBarDelegate(new FooA(), new BarA());
    }
    public FooBar fooBbarA() {
        return new FooBarDelegate(new FooB(), new BarA());
    }
    public FooBar fooAbarB() {
        return new FooBarDelegate(new FooA(), new BarB());
    }
    public FooBar fooBbarA() {
        return new FooBarDelegate(new FooB(), new BarB());
    }
}