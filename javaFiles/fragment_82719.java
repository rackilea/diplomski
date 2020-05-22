public static <M extends Model> List<M> all(Supplier<M> constructor) {
    List<M> models = new ArrayList<>();

    for ( /* ... */ ) {
        M model = constructor.get();

        // initialize model here
        // ...

        models.add(model);
    }
}