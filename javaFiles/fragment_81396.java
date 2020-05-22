<P, T> List<T> createGenericList(Function<? super P, ? extends T> func, List<? extends P> params) throws Exception {
    List<T> list = new ArrayList<T>();
    for (P param : params) {
        T instance = func.apply(param);
        list.add(instance);
    }
    return list;
}