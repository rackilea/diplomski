class Test {
    private Object[] member = new Object[10];

    public void foo() {
        member[0].toString(); // NullPointerException
        Object[] local = new Object[10];
        local[0].toString(); // NullPointerException
    }
}