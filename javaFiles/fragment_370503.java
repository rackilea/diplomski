@Stateless
public class TLinkEquipementDAOImpl implements TLinkEquipementDAO {   
    private static final Log log = LogFactory.getLog(TLinkEquipementDAOImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    public void persist(TLinkEquipement transientInstance) {
        log.debug("persisting TLinkEquipement instance");
        entityManager.persist(transientInstance);
        log.debug("persist successful");
    }
//Staff
}