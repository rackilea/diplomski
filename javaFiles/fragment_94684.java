@Singleton
@Startup
public class ClientResetBean {

    // Injected database connection:
    @PersistenceContext private EntityManager em;


    @PostConstruct
    private void resetClientState() {
        Query query = em.createQuery("UPDATE Client c SET c.online = false");
        query.executeUpdate();
    }
}