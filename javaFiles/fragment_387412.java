public final String tableName;
public DomainRepository(String tableName) {
      this.tableName = tableName;
}
public List<T> getAll(Integer status) {
    Session session = sessionFactory.getCurrentSession();
    Query query = session.createQuery("FROM " + tableName + " WHERE status = " + status);
    return query.list();
}