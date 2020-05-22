public List<Person> queryByPropertyValues(Map<String, Object> properties) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Person> query = cb.createQuery(Person.class);
    Root<Person> person = query.from(Person.class);
    Predicate predicate = cb.and(); // == always true
    for (Map.Entry<String, Object> property : properties.entrySet()) {
        predicate = cb.and(predicate, cb.equal(person.get(property.getKey()), property.getValue()));
    }
    query.where(predicate);
    return em.createQuery(query).getResultList();
}