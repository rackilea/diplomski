EntityManager entityManager = entityManagerFactory.createEntityManager();

entityManager.getTransaction().begin();

AmmEdGroupTypes newGroup = new AmmEdGroupTypes();
newGroup.setName("test");
entityManager.persist(newGroup);
entityManager.getTransaction().commit();
System.out.println(newGroup.getId());