final EntityManagerFactory emf = Persistence.createEntityManagerFactory("xy");
final EntityManager em = emf.createEntityManager();
em.getTransaction().begin();

java.sql.Connection connection = em.unwrap(java.sql.Connection.class);
System.out.println(connection.getTransactionIsolation());

....
em.getTransaction().commit();