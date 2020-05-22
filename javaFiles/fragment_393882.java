public abstract class BaseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getHibernateSession() {
        return sessionFactory.getCurrentSession();
    }
}