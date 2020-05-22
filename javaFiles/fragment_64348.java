public interface Foo<T extends Bar> {
    boolean isA(T t);
    T B();

    default boolean bIsA() {
        return this.isA(this.B());
    }
}