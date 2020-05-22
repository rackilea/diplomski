interface I {
    void m(String s);
}

class C implements I {
    @Override
    public void m(Object o) {}
}