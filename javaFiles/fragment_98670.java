class A {
    String a;
    List<..> b;
    int c;

    public void merge(A other) {
        this.a = other.a == null ? this.a : other.a;
        this.b.addAll(other.b);
        this.c = other.c == 0 ? this.c : other.c;
    }
}

A a1 = new A();
A a2 = new A();

a1.a = "a prop";
a2.c = 34;

a1.merge(a2);