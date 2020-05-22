public class HibernateRepository<E extends Object, EId>
   implements EntityRepository<E, EId> {
    private Class<E> clazz;

    public HibernateRepository(Class<E> clazz) {
        this.clazz = clazz;
    }

    @Override
    public E getById(EId id) {
        return entityManager.getReference(clazz, id); // <<< Error here!
    }
}