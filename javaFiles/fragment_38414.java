class A {
    final B b;

    A(B b) {
        this.b = b;
    }
}

abstract class B {
    final A a;

    B() {
        this.a = constructA();
    }

    protected abstract A constructA();
}

public class C {
    public static void main(String []args){
        new B(){
            protected A constructA(){
                return new A(this);
            }
        };
    }
}