interface NonGenericThing extends Thing {
    @Override
    default <T extends Comparable<? super T>>
    void doSomething(List<T> list) {
        doSomethingImpl(list);
    }
    void doSomethingImpl(List<?> list);
}