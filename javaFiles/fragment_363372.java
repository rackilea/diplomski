@PersistenceContext
EntityManager entityManager;

public String getTableName(Class entityClass){

    SessionFactory sessionFactory = ((Session) entityManager.getDelegate()).getSessionFactory();

    ClassMetadata classMetadata = sessionFactory.getClassMetadata(entityClass);

    SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;

    AbstractEntityPersister entityPersister 
            = (AbstractEntityPersister) sessionFactoryImpl.getEntityPersister(classMetadata.getEntityName());

    return entityPersister.getTableName();
}