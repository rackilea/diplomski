public class SecurityPolicyInjectingJpaTransactionManager extends JpaTransactionManager {
  @Autowired
  private EntityManager entityManager;

  // constructors

  @Override
  protected void prepareSynchronization(DefaultTransactionStatus status, TransactionDefinition definition) {
    super.prepareSynchronization(status, definition);
    if (status.isNewTransaction()) {
      // Use entityManager to execute your database policy param/values

      // I would suggest you also register an after-completion callback synchronization
      // This after-completion would clear all the policy param/values
      // regardless of whether the transaction succeeded or failed 
      // since this happens just before it gets returned to the connection pool
    }
  }
}