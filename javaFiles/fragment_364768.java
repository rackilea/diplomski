enum Foo {
    A {
        @Override
        public void execute() {
            //...
            commonCode();
            // ...
        }
    },
    B {
        @Override
        public void execute() {
            //...
            commonCode();
            // ...
        }
    };

    public abstract void execute();

    protected void commonCode() {
        // ...
    }
}