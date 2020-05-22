class EntityType<K, T> {
    private final Supplier<DAO<K, T>> constructor;

    private EntityType(Supplier<DAO<K, T>> constructor) {
        this.constructor = constructor;
    }

    public DAO<K, T> createDAO() {
        return constructor.get();
    }

    public static final EntityType<String, Course> COURSE = new EntityType<>(CourseDAO::new);
    public static final EntityType<Long, Student> STUDENT = new EntityType<>(StudentDAO::new);
}