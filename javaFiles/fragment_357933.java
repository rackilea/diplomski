class A {
    protected int x = 1;
}

class B extends A {
    protected int x = 2;
}

class C extends B {
    int getAx() {
        return ((A) this).x;
    }

    void setAx(int x) {
        ((A) this).x = x;
    }
}