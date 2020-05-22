@PersistenceContext
private EntityManager entityManager;

@Transactional
public List<Person> foo() {
   // example for accessing hibernate directly, you could also use QueryDSL and so on
   Criteria basicCriteria = entityManager.unwrap().createCriteria(Person.class);
   if (someCondition) {
      criteria.add(Restrictions.eq("foo", foo));
      ...
   }
   ...
   return criteria.list();
}