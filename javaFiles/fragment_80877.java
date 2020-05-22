public void persistPerson(PersonEntity personEnt){
    EntityManager em = EntityManagerHelper.getEntityManager();

    em.getTransaction().begin();
    em.persist(personEnt);
    em.getTransaction().commit();

    em.clear();
    em.close(); 
}