new A() {
    {
        new B() {{
            method(a);
        }};
    }
    private A a() {
        return this;
    }
}