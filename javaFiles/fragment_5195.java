public void insert(Group group) {
    try {
        em.persist(group);
        em.flush();
    } catch (PersistenceException pe) {

    }
}