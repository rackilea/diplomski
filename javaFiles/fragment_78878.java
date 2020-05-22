@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class TimedRequestBean implements TimedRequestLocal, TimedObject {    
    @Resource
    private SessionContext sessionContext;
    public void cancelTimers() {
            TimerService ts = this.sessionContext.getTimerService();
            Collection timers = ts.getTimers();
            Iterator it = timers.iterator();
            while (it.hasNext()) {
                Timer myTimer = (Timer)it.next();
                myTimer.cancel();
            }
       }
}