try {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("Auditing");
        em = emFactory.createEntityManager();
        // do whatever you need to do
        em.close();
        emFactory.close();
} catch (Exception ex) {
        throw new RuntimeException(ex.getMessage());
}