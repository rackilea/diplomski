public Optional<User> findBy(String username) {
    return emp.get().createQuery("select u from User u where u.username = :username", User.class)
            .setParameter("username", username)
            .setMaxResults(1)
            .getResultList()
            .stream()
            .findFirst();
}