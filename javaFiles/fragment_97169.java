abstract class EntityType<K, T> {
    public abstract DAO<K, T> createDAO();

    public static final EntityType<String, Course> COURSE = new EntityType<String, Course>() {
        @Override
        public DAO<String, Course> createDAO() {
            return new CourseDAO();
        }
    };
    public static final EntityType<Long, Student> STUDENT = new EntityType<Long, Student>() {
        @Override
        public DAO<Long, Student> createDAO() {
            return new StudentDAO();
        }
    };
}