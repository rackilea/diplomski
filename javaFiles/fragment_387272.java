public class MultiMapType implements UserCollectionType {

public boolean contains(Object collection, Object entity) {
    return ((MultiMap) collection).containsValue(entity);
}

public Iterator getElementsIterator(Object collection) {
    return ((MultiMap) collection).values().iterator();
}

public Object indexOf(Object collection, Object entity) {
    for (Iterator i = ((MultiMap) collection).entrySet().iterator(); i.hasNext();) {
        Map.Entry entry = (Map.Entry) i.next();    
        Collection value = (Collection) entry.getValue();
        if (value.contains(entity)) {
            return entry.getKey();
        }
    }
    return null;
}

public Object instantiate() {
    return new MultiHashMap();
}

public PersistentCollection instantiate(SessionImplementor session, CollectionPersister persister) throws HibernateException {
    return new PersistentMultiMap(session);
}

public PersistentCollection wrap(SessionImplementor session, Object collection) {
    return new PersistentMultiMap(session, (MultiMap) collection);
}

public Object replaceElements(Object original, Object target, CollectionPersister persister, Object owner, Map copyCache, SessionImplementor session) throws HibernateException {

    MultiMap result = (MultiMap) target;
    result.clear();

    Iterator iter = ( (java.util.Map) original ).entrySet().iterator();
    while ( iter.hasNext() ) {
        java.util.Map.Entry me = (java.util.Map.Entry) iter.next();
        Object key = persister.getIndexType().replace( me.getKey(), null, session, owner, copyCache );
        Collection collection = (Collection) me.getValue();
        for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
            Object value = persister.getElementType().replace( iterator.next(), null, session, owner, copyCache );
            result.put(key, value);
        }
    }

    return result;
}