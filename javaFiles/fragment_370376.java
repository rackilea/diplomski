public class A {
    private B b;

    public A() {
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public void main(String[] args){
        A a=new A();
        B b=new B();

        a.setB(b);
        b.setA(a);

        //because all that a and b contain is references this circular referencing
        //doesn't blow up

        //this line is stupid, but perfectly valid
        A referenceToAnA=b.getA().getB().getA().getB().getA();

    }

}

public class B {
    private A a;

    public B() {
    }

    public void setA(A a) {
        this.a = a;
    }

    public A getA() {
        return a;
    }


}