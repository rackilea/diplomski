public <T> List<T> getAll(final Class<T> clazz) {

    ParameterizedType parameterizedGenericType = new ParameterizedType() {
        public Type[] getActualTypeArguments() {
            return new Type[] { clazz };
        }

        public Type getRawType() {
            return List.class;
        }

        public Type getOwnerType() {
            return List.class;
        }
    };

    GenericType<List<T>> genericType = new GenericType<List<T>>(
            parameterizedGenericType) {
    };

    return service.path(Path.ROOT).path(clazz.getSimpleName())
            .accept(MediaType.APPLICATION_XML).get(genericType);
}