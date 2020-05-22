public class TestBeanJUnit {

    static EntityManager em = null;
    static EntityTransaction tx = null;

    static TestBean tb = null;
    static EntityManagerFactory emf = null;

    @BeforeClass
    public static void init() throws Exception {
        emf = Persistence.createEntityManagerFactory("puTest");
    }

    @Before
    public void setup() {
        try {
            em = emf.createEntityManager();
            tx = em.getTransaction();
            tx.begin();
            tb =  new TestBean();
            Field field = TestBean.class.getDeclaredField("entityManager");
            field.setAccessible(true);
            field.set(tb, em);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @After
    public void tearDown() throws Exception {
        if (em != null) {
            tx.commit();
            em.close();
        }
    }

}