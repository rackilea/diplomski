class A<X extends IA<X,Y>, Y extends IB<X,Y>> implements IA<X,Y>{}
class B<X extends IA<X,Y>, Y extends IB<X,Y>> implements IB<X,Y>{}
interface IA<X extends IA<X,Y>, Y extends IB<X,Y>> {}
interface IB<X extends IA<X,Y>, Y extends IB<X,Y>> {}

class M<X extends IA<X,Y>, Y extends IB<X,Y>> extends W<X,Y>{
    public M(IA<X,Y> x, IB<X,Y> y){} // this is the only change
}

class W<X extends IA<X,Y>, Y extends IB<X,Y>> {}


//To my check class code:

public <X extends IA<X,Y>, Y extends IB<X,Y>> void check() {
    IA<X,Y> a = new A<X,Y>();
    IB<X,Y> b = new B<X,Y>();

    W<X,Y> s = new M<X,Y>(a,b);
}