@Stateless  
public class EmployeeServiceBean implements EmployeeService {

    // Transactional method
    public void createEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        Employee emp = ...; // set some data
        // No need for manual join - em created in active tx context, automatic join:
        // em.joinTransaction();         
        em.persist(emp);
        // other data & em operations ...
        // call other EJBs to partake in same transaction ...
        em.close();    // Note: em can be closed before JTA tx committed. 
                   // Persistence Context will still exist & be propagated 
                   // within JTA tx.  Another EM instance could be declared and it 
                   // would propagate & associate the persistence context to it.
                   // Some time later when tx is committed [at end of this 
                   // method], Data will still be flushed and committed and 
                   // Persistence Context removed .
    emf.close();
    }

}



@Stateful  
public class EmployeeServiceBean implements EmployeeService {  

    // Because bean is stateful, can store as instance vars and use in multiple methods  
    private EntityManagerFactory emf;
    private EntityManager em;

    @PostConstruct      // automatically called when EJB constructed and session starts
    public void init() {
        emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
    }

    // Transactional method
    public void createEmployee() {
        Employee emp = ...; // set some data
        em.joinTransaction();         // em created before JTA tx - manual join
        em.persist(emp);
    }

    // Transactional method
    public void updateEmployee() {
        Employee emp = em.find(...);  // load the employee
        // don't do join if both methods called in same session - can only call once: 
        // em.joinTransaction();         // em created before JTA tx - manual join
        emp.set(...);                 // change some data
                             // no persist call - automatically flushed with commit
    }

    @Remove                           // automatically called when EJB session ends
    public void cleanup() {
        em.close();
        emf.close();
    }
// ...
}