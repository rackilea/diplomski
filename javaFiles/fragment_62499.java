class C {
    public A getA();
    public B getB();
}

C c = new C();
int a = c.getA().foo();
double b = c.getB().foo();