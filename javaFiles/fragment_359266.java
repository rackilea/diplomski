@Repository
@Transactional
public class FooDao implements IFooDao {

    private SessionFactory sessionFactory;

    @Autowired
    public FooDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public FooDao() {
    }

    private Session currentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Cacheable(cacheName="secretryCache")
    public Foo getFoo(int id) {

        return (Foo)currentSession().load(Foo.class, id);

    }
}