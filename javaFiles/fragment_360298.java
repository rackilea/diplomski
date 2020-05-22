@Transactional
public abstract class AbstractEntityDao<E> {
    @PersistenceContext(unitName = "some-persistence")
    protected EntityManager em;

    public E create(E e) {
        em.persist(e);
        return e;
    }
    (...)
}