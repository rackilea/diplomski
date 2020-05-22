em = getEntityManager();
Link existing = em.find(Link.class, link.getLink());
if (existing == null) {
    em.getTransaction().begin();
    em.persist(link);
    em.getTransaction().commit();
}