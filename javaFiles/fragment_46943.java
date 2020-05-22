public class BaseDao {

    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {

        if (emf == null) {

            emf = Persistence.createEntityManagerFactory("test");
        }

        return emf.createEntityManager();
    }
}