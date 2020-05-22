Class A {
    private B b;

    public void dispose() {
        b.dispose();
    }
}

Class B {
    private A a;

    public void dispose() {
        a.dispose();
    }
}