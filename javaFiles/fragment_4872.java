@PersistenceContext
private EntityManager em;

public <M extends AbstractModel> List<M> findAll() {
    return em.createQuery("select b FROM Building b", Building.class).getResultList();
}