@Service
public class BuyerService {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Buyer save(Buyer buyer) {
        return entityManager.merge(buyer);
    }

}