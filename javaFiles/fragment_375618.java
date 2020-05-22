class Test {
    private Object[] member;

    public void foo() {
        member.toString(); // NullPointerException
        Object[] local;
        local.toString(); // won't compile: The local variable local may not have been initialized
    }
}