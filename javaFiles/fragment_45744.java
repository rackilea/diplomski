@Test
public void test_Add_B_To_A() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPu");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();

    A a = em.find(A.class, 1L);

    B b = new B();
    A.addToBs(b); // convenient method that manages the bidirectional association

    em.getTransaction().commit(); // pending changes are flushed

    em.close();
    emf.close();

    assertNotNull(b.getId());
}