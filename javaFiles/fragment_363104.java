@TransactionManagement(TransactionManagement.BEAN)  
@Stateless  
public class EmployeeServiceBean implements EmployeeService {

    // inject the JTA transaction interface
    @Resource UserTransaction jtaTx;

    public void createEmployee() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        EntityManager em = emf.createEntityManager();
        try {
            jtaTx.begin();
            try {
               em.joinTransaction();         
               Employee emp = ...; // set some data
               em.persist(emp);
               // other data & em operations ...
               // call other EJBs to partake in same transaction ...
            } finally {
                jtaTx.commit();
            }
        } catch (Exception e) {
           // handle exceptions from UserTransaction methods
           // ...
        }

        Employee emp = ...; // set some data
        // No need for manual join - em created in active tx context, automatic join:
        // em.joinTransaction();         
        em.persist(emp);
        em.close();    // Note: em can be closed before JTA tx committed. 
                   // Persistence Context will still exist inside JTA tx.
                   // Data will still be flushed and committed and Persistence 
                   // Context removed some time later when tx is committed.
        emf.close();
    }

}