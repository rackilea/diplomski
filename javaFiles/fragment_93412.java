public abstract class IdGeneratorHolder {
    /* PersistentEntity is a marker interface */
    public static IdGenerator getIdGenerator(Class<? extends PersistentEntity> entityType) {
             /* sample impelementation */
        if(Product.class.isAssignableFrom(entityType)) {
            return new ProductIdGenerator();

        }
        return null;
    }
}