@Override
public void makeTransient(T entity) {
    T newEntityRef =    getSession().merge(entity);  
    getSession().getTransaction().begin();
    getSession().delete(newEntityRef);
    getSession().getTransaction().commit();
}