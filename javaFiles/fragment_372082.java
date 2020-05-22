class A {
    private A(int n)  { }

    public static A create(int n) {
        return new A(n);
    }
}