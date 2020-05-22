public abstract class AbstractServiceImpl<T extends Object> implements AbstractService<T> {
    private AbstractDao<T> dao;

    abstract AbstractDao<T> getDao();

    public void save(T t) {
        getDao().save(t);
    }
}

public class FooServiceImpl extends AbstractServiceImpl<Foo> {
     @Autowired
     private FooDao fooDao;

     @Overrides
     public AbstractDao<Foo> getDao() {
         return fooDao;
     }
}