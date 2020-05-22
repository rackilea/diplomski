@Stateless
public class SynchronisationService {
    @Schedule(hour = "*", minute = "*", persistent = false)
    protected void init(Timer timer)
    {
       doTheSync();

       timer.cancel();
    }
 }