public class DomainRepository<T> {

    @Resource(name = "sessionFactory")
    protected SessionFactory sessionFactory;

 public DomainRepository(Class genericType) {
        this.genericType = genericType;
    }

 @Transactional(readOnly = true)
    public T get(final long id) {
        return (T) sessionFactory.getCurrentSession().get(genericType, id);
    }