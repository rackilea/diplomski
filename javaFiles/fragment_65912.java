class A {
    private B b;
    public void setB(B b){
        this.b = b;
    }
}    

class B {
    private A a;
    public void setA(A a){
        this.a = a
    }
}

A a = new A();
B b = new B();
a.setB(b);
b.setA(a);