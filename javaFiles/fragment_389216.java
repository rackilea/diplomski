public abstract class DBStore<T extends Entity> implements IRepository<T> {
    DaoMaster daoMaster;
    Class<T> entityClass;

    public DBStore(DaoMaster daoMaster, Class<T> entityClass) {
        this.daoMaster = daoMaster;
        this.entityClass = entityClass;
    }

    @Override
    public void add(T entity) {
        this.getSession().insert(entity);
    }

    @Override
    public T getById(long id) {
        AbstractDao<T, Long> dao = this.getDao();
        return dao.load(id);
    }

    //other methods

    protected AbstractDao<T, Long> getDao(){
        DaoSession session = this.daoMaster.newSession();
        return (AbstractDao<T, Long>) session.getDao(this.entityClass);
    }

    protected DaoSession getSession(){
        return this.daoMaster.newSession();
    }
}