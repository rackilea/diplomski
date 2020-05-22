public class ClassBuilder {
    private final Class<?> clazz;
    private final List<ClassBuilder> parameters = new ArrayList<>();

    public ClassBuilder(final Class<?> clazz) {
        this.clazz = clazz;
    }

    public static ClassBuilder parse(String clazz) {
        try {
            return new ClassBuilder(Class.forName(clazz));
        } catch (ClassNotFoundException e) {
            // do better handling here
            throw new IllegalStateException(e);
        }
    }

    public void add(ClassBuilder builder) {
        parameters.add(builder);
    }

    public Type build() {
        // class is not parametrized
        if (parameters.isEmpty()) {
            return clazz;
        }

        return ParameterizedTypeImpl.make(
                clazz,
                parameters.stream()
                          .map(ClassBuilder::build)
                          .toArray(Type[]::new),
                null);
    }
}