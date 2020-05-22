class MyClass {
    private final int value_; // must be assigned at construction

    public MyClass() {
        value_ = 42; // must assign a value
    }

    public void foo() {
        value_ = 123; // compile error if you try to assign to a final field
    }
};