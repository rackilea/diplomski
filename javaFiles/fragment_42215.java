EntityManager em;

public List<Person> queryByPropertyValue(String propertyName, Object value) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Person> query = cb.createQuery(Person.class);
    Root<Person> person = query.from(Person.class);
    query.where(cb.equal(person.get(propertyName), value));
    return em.createQuery(query).getResultList();
}