@Aspect
public class AspectAroundTransactions() {
   @Pointcut("execution(* org.springframework.*.AbstractPlatformTransactionManager.getTransaction(..))" )
   public void newTransaction() {}

   @Before("newTransaction() && args(transactionDefinition,..)")
   public void beforeStartOfTransaction(TransactionDefinition transactionDefinition) {
      // here goes you code
      long start = System.nanoTime();
      System.out.println("Transaction " + transactionDefinition.getName() + " started at " + start );
   }
}