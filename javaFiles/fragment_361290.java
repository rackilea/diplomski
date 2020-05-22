@Component 
public class ScheduledTask {

private AtomicBoolean isRunning = new AtomicBoolean(false);

@Scheduled(fixedRate = 60*1000)
public void run() {
   if (isRunning.compareAndSet(false, true)) {

       // ... do your things

      //whenever you are done
      isRunning.set(false);
   }