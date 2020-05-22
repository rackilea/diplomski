@Stateless
public class TimeoutTest implements TimeoutTestLocal {

@Resource
TimerService timerService;

@Resource
SessionContext sessionContext;

@Timeout
@TransactionAttribute(TransactionAttributeType.NEVER)
public void tmout(javax.ejb.Timer timer) {
    try {
        System.out.println("timout invoked");
        //instead of internal call let's invoke doNothing as
        //this timeout callback is client of TimeoutTest EJB
        //in this way doNothing will be run inside transaction
        TimeoutTestLocal local = sessionContext.getBusinessObject(TimeoutTestLocal.class);
        local.doNothing();  
    } catch (Exception e) {
        timer.cancel();
        System.out.println("Timer cancelled");
    }
}

@Override 
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public void doNothing() {
    throw new EJBException("RE Exception");
}


@Override
public void schedule() {
    timerService.createTimer(5000, 10000, "test");
}
}