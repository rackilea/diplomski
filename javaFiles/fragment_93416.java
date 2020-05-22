public abstract class IdGeneratorHolder {
    public static IdGenerator getIdGenerator(Class<? extends PersistentEntity> entityType) {
        try { // again sample implementation
            Method method = entityType.getMethod("idMethod");
            CustomIdGenerator gen = method.getAnnotation(CustomIdGenerator.class);
            IdStrategy strategy = gen.strategy();
            return new ProductIdGenerator(strategy);
        }