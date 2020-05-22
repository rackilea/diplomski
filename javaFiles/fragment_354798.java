List<User> users = new ArrayList<User>();

users = sessionFactory.getCurrentSession()
    .createQuery("from User where username=?")
    .setParameter(0, username)
    .list();

if (users.size() > 0) {
    return users.get(0);
} else {
    return null;
}