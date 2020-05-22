public abstract static class A { 
    public abstract B toB();
}
public static class A1 extends A {
    @Override
    public B1 toB() {
        return new B1();
    } 

}

public static class B {

}
public static class B1 extends B { 

}