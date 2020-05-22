@LocalBean
@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class MyEJB implements MyEJBRemote {

    @Override
    @Asynchronous
    public void myMethod() throws RuntimeException {
        //for testing
        while (true){
            Thread.sleep(5000);
            logger.info("Running asynchronous method");
        }
        //Method code here
    }
}