public class HibernateDao <T, ID extends Serializable> implements GenericDao<T, ID> {

    private final Class<? extends T> type;

    public HibernateDao(Class<? extends T> type) {
        this.type = type;
    }

    // ....

}