public class X<T extends A> {

    protected T a;

    public X(T a) {
        this.a = a;
    }
}

public clas Y extends X<B> {

    public Y(B b) {
        super(b);
    }

    public void foo() {
        // here, this.a is of type B, without any type cast.
    }
}