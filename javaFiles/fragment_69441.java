public interface InterfaceA<B extends InterfaceA.InterfaceB<?>> {

    public interface InterfaceB<A extends InterfaceA<B>> { //<- cannot make a static reference to the non-static type B

        void setA(A a);
    }
}