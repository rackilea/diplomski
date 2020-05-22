EntityManagerFactory emf = Persistence.createEntityManagerFactory("library");
EntityManager em = entityManagerFactory.createEntityManager();
// Query with where clausel
// I 'lower' the user name and use a TypedQuery
// the password should be case sensentive
TypedQuery<User> query = entityManager.createQuery("from users u where lower(u.username) = :name and u.password = :password", User.class);
query.setParameter("name", "foo");
query.setParameter("password", "pwd");
try {
    User user = query.getSingleResult();
    System.out.println("User found");
} catch( javax.persistence.NoResultException e ){
    System.out.println("No user found");
}