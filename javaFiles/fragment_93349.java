@Transactional
public static List<Contract> findAllContractsPerContract(Contract contract) {
    EntityManager e = entityManager().getEntityManagerFactory().createEntityManager();
    Session session = e.unwrap(Session.class);
    Example contractExample = Example.create(contract);
    Criteria c = session.createCriteria(Contract.class).add(contractExample);
    List<Contract> list = c.list();
    return list;
}