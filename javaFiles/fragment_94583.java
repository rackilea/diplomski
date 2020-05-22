public class JobThread implements Runnable
{

  private static JobService jobService;
  private static long interval;
  private static JobThread myObj;

  static
  {
    myObj = new JobThread ();
  }

  private JobThread ()
  {

  }

   @Override public void run ()
  {
    //some stuff
  }

  public static JobThread getInstance (JobService jobService_p,
                       long interval_p)
  {
    jobService = jobService_p;
    interval = interval_p;
    return myObj;
  }
}