public abstract class BaseDao<E extends BaseEntity> {

    @PersistenceContext
    private EntityManager em;

    private Class<E> type;

    @SuppressWarnings("unchecked") // For the cast on Class<E>.
    public BaseDao() {
        Type type = getClass().getGenericSuperclass();

        while (!(type instanceof ParameterizedType) || ((ParameterizedType) type).getRawType() != BaseDao.class) {
            if (type instanceof ParameterizedType) {
                type = ((Class<?>) ((ParameterizedType) type).getRawType()).getGenericSuperclass();
            } else {
                type = ((Class<?>) type).getGenericSuperclass();
            }
        }

        this.type = (Class<E>) ((ParameterizedType) type).getActualTypeArguments()[0];
    }

    public E find(Long id) {
        return em.find(type, id);
    }

    public List<E> list() {
        return em.createQuery(String.format("SELECT e FROM %s e ORDER BY id", type.getSimpleName()), type).getResultList();
    }

    // ...
}