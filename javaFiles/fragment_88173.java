public class MapCriteria extends CriteriaImpl implements Criteria {

public MapCriteria( Criteria criteria ) {
super( ((CriteriaImpl)criteria).getEntityOrClassName(), ((CriteriaImpl)criteria).getSession() );
}

public <I, T> Map<I, T> map( String indexMethodName ) throws HibernateException {
Map<I, T> map = null;
try {
    List<T> results = list();
    if ( null != results ) {
    map = new HashMap<I, T>();
    if ( !results.isEmpty() ) {
        Class clazz = Class.forName( getEntityOrClassName() );
        Class[] params = new Class[0];
        Method method = clazz.getMethod( indexMethodName, params );
        Object[] args = new Object[0]; 
        for ( T result : results ) {
        I index =  (I) method.invoke( result, args );
        map.put( index, result );
        }
    }
    }
}
catch (ClassNotFoundException e) {
    throw new HibernateException( e );
}
catch (NoSuchMethodException e) {
    throw new HibernateException( e );
}
    catch (IllegalArgumentException e) {
    throw new HibernateException( e );
    }
    catch (IllegalAccessException e) {
    throw new HibernateException( e );
    }
    catch (InvocationTargetException e) {
    throw new HibernateException( e );
    }
return (Map<I, T>) map;
}