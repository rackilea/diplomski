@LocalBean
@Stateless
@TransactionAttribute(TransactionAttributeType.NEVER)
public class MyEJBCaller {

    @EJB
    private MyEJB myEJB;

    public void request() throws RuntimeException {
        logger.info("Begin");
        myEJB.myMethod();
        logger.info("End");
    }
}