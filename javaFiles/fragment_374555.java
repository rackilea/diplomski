EntityManagerFactory emfactory=Persistence.createEntityManagerFactory("Eclipselink_JPA" );
  EntityManager entitymanager = emfactory.createEntityManager();

  Query query = entitymanager.
  createQuery("Select p from Person p");
  List<String> list = query.getResultList();