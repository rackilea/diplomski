@Transactional(readonly=true)
public List<Person> getPersons() {
  Session session = sessionFactory.getCurrentSession();
  //find those darn people.
}
@Autowired
private SessionFactory sessionFactory;