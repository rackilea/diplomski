@Override
public void updateResource(Resource resource) {
    Session session = this.sessionFactory.getCurrentSession();
    session.update(resource);

}