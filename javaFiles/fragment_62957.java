public class CustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveAllInBatch(List<Ent> entities, int batchSize) {
        Session session = em.unwrap(Session.class);
        session.setJdbcBatchSize(batchSize);

        em.saveAll(entities);
    }
}