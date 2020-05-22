private static <S, T> void loadTable(
        ObservableList<S> ol,
        Map<T, S> hm,
        List<List<Object>> rs,
        Supplier<? extends S> factory,
        BiConsumer<? super S, List<Object>> initializer,
        Function<? super S, ? extends T> idExtractor) {

    for (List<Object> resultRow : rs) {
        S o = factory.get();
        initializer.accept(o, resultRow);
        hm.put(idExtractor.apply(o), o);
        ol.add(o);
    }
}