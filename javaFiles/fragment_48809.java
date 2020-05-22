new A() {
    {
        new B() {{
            method();
        }};
    }
    private void method() {
        method(this);
    }
}