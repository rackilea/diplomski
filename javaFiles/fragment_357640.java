EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory( "eshop" );
EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.getTransaction().begin();
// perform operations here
entityManager.getTransaction().commit();
entityManager.close();
entityManagerFactory.close();