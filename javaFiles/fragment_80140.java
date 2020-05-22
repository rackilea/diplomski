@ContextConfiguration(classes = { test.SpringTestConfigurator.class })
    @TransactionConfiguration(defaultRollback = false)
    @Slf4j
    @WebAppConfiguration
    public class DBDataTest extends AbstractTransactionalTestNGSpringContextTests {    
    /**
     * Variable to determine if some running thread has failed.
     */
    private volatile Exception threadException = null;

   @Test(enabled = true)
    public void myTest() {
        try {
            this.threadException = null;
            Runnable task = () -> {
                myTestBody();
            };
            ExecutorService executor = Executors.newFixedThreadPool(1);
            executor.submit(task);
            executor.shutdown();
            while (!executor.isTerminated()) {
                if (this.threadException != null) {
                    throw this.threadException;
                }
            }
            if (this.threadException != null) {
                throw this.threadException;
            }
        } catch (Exception e) {
            log.error("Test has failed.", e);
            Assert.fail();
        }
    }

 public void myTestBody() {
    try {
        // test body to do
    }
    catch (Exception e) {
       this.threadException = e; 
    } 
 } 
}