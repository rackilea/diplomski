public interface MyType {
    void contractOperation1();
    default void optionalOperation2() {
        throw new UnsupportedOperationException();
    }
}