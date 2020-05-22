public List<Local> listLocal(String userLogin) {
    Query query = sessionFactory.getCurrentSession()
          .createQuery("select u.userLocales from User u where u.login = ?");
    query.setParameter(0, userLogin);
    return query.list();
}