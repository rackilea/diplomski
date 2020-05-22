@Transactional
public class PersonService {
    @PersistenceContext 
    private EntityManager em;

    public void savePerson(Person person) {
    em.persist(person);
}