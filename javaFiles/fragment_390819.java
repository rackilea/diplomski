public Optional<User> findBy(String username) {
    return findOrEmpty(() ->
            emp.get().createQuery("select u from User u where u.username = :username", User.class)
                    .setParameter("username", username)
                    .setMaxResults(1)
                    .getSingleResult());
}