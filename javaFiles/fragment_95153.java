class a {
    public void f() {
        System.out.println("hi");
    }
}

class b extends a {
    public void f() {
        System.out.println("hi2");
    }

    public void f2() {
        super.f();
    }
}