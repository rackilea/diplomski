private static SessionFactory sessionFactory;

@BeforeClass
public static void beforeClass() {
    sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
}