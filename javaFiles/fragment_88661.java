public class DataBroker {

    private EntityManager em;

    public DataBroker() {
        init();
    }

    private void init() {
        this.em = Persistence.createEntityManagerFactory("<NAME_OF_YOUR_PU>").createEntityManager();
    }

    public Person saveOrUpdate(Person entity) {
        em.getTransaction().begin();
        T savedEntity = em.merge(entity);
        em.getTransaction().commit();
        return savedEntity;
    }

    public List<Person> getAllPersons() {
        TypedQuery<Person> query = em.createNamedQuery(Person.GET_ALL, Person.class);
        return query.getResultList();
    }

}