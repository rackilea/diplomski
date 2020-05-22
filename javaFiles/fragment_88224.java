@Override
public void updateResource(Resource resource) {
    Session session = this.sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.update(resource);
    session.getTransaction().commit();

}