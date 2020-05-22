public class TestCollectionType implements UserCollectionType {
    @Override
    public PersistentCollection instantiate(SessionImplementor session, CollectionPersister persister)
                    throws HibernateException {
            return new Wrapper(new PersistentSet(session));
    }
    @Override
    public Object instantiate(int anticipatedSize) {
            return new Wrapper(new HashSet<>());
    }

    @Override
    public PersistentCollection wrap(SessionImplementor session, Object collection) {
            return new Wrapper(new PersistentSet(session, (Set<?>)collection));
    }

    @Override
    public Iterator getElementsIterator(Object collection) {
            return ((Set<?>)collection).iterator();
    }

    @Override
    public boolean contains(Object collection, Object entity) {
            return ((Set<?>)collection).contains(entity);
    }

    @Override
    public Object indexOf(Object collection, Object entity) {
            throw new UnsupportedOperationException();
    }

    @Override
    public Object replaceElements(Object original, Object target, CollectionPersister persister, Object owner,
                    Map copyCache, SessionImplementor session) throws HibernateException {
            ((Set<?>)target).clear();
            ((Set<?>)target).addAll((Set)original);
            return target;
    }
}