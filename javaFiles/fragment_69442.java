public interface InterfaceA<B extends InterfaceA.InterfaceB<?>> {

    public interface InterfaceB<A extends InterfaceA<? extends InterfaceA.InterfaceB<?>>> {

        void setA(A a);
    }
}


abstract class AImplTwo<B extends InterfaceA.InterfaceB<A>, A extends InterfaceA<B>> implements InterfaceA<B> {

    private final B b;

    public AImplTwo(B b) {
        this.b = b;
        b.setA((A)this); // <-- Unchecked cast
    }
}