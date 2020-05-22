public class TLinkEquipementDAOImpl implements TLinkEquipementDAO {   
    private static final Log log = LogFactory.getLog(TLinkEquipementDAOImpl.class);

    //I'm assuming getEntityManagerFactory() returnes an already created EMF
    private EntityManagerFactory emf = PersistenceManager.getInstance()
            .getEntityManagerFactory();
    private EntityManager entityManager = emf.createEntityManager();

    public void persist(TLinkEquipement transientInstance) {
        EntityTransaction tx = entityManager.getTransaction();
        log.debug("persisting TLinkEquipement instance");
        try {
            tx.begin();
            entityManager.persist(transientInstance);
            tx.commit();
            log.debug("persist successful");
        } catch (RuntimeException re) {
            log.error("persist failed", re); 
            if(tx.isActive()) {
                tx.rollback();
            }
            throw re;
        }
    }
//Staff
}