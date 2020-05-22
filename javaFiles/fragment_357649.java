@Stateless
public class TransactionDataControllerImpl {

    private static Logger log = ...;

    @PersistenceContext
    private EntityManager entityManager;

    public NonTlf saveNonTlfTransaction(NonTlf trandata) {
        try
        {
            TSN tsn =  null;

            final String queryString = "select model from TSN model where model.vtmId= :propertyValue";
            TypedQuery<TSN> query = entityManager.createQuery(queryString, TSN.class);
            query.setLockMode(LockModeType.PESSIMISTIC_WRITE);
            query.setParameter("propertyValue", trandata.getTerminalId());
            //System.out.println(trandata.toString());

            try {
                tsn = query.getSingleResult();

            } catch(NoResultException e) {
                log.error("Transaction save failed" , e); // what does this mean?
                tsn = new TSN();
                tsn.setTsn(1);
                tsn.setVtmId(trandata.getTerminalId());
                entityManager.persist(tsn);
                entityManager.lock(tsn, LockModeType.PESSIMISTIC_WRITE);
            }
            if(tsn.getTsn() == 9999)
                tsn.setTsn(0);
            tsn.setTsn(tsn.getTsn() + 1);
            tsn = entityManager.merge(tsn);

            trandata.setTsn(String.format("%04d",tsn.getTsn()));

            entityManager.persist(trandata);

            System.out.println("Transaction id: " + trandata.getId());

            return (trandata);
        } catch(Exception e) {
            log.error("Transaction save failed" , e);
            e.printStackTrace();
            return (null);
        }
    }

}