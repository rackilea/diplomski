enum Foo {
    A {
        @Override
        protected void specificCode() {
            //...
        }
    },
    B {
        @Override
        public void specificCode() {
            //...
        }
    };

    public void execute() {
        // ... common code
        specificCode();
        // ... common code
    }

    protected abstract void specificCode();
}