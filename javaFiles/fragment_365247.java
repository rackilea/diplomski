@WebServlet("/.../api/long/running/process/start")
public class LongRunningProcessStartHandler extends HttpServlet  {
    public void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException  {

    AtomicInteger percentComplete = new AtomicInteger(0);
    request.getSession().setAttribute("LONG_RUNNING_PROCESS_STATUS", percentComplete);

    LongRunningProcess lrp = new LongRunningProcess(percentComplete);
    lrp.start();

}

public class LongRunningProcess extends Thread {
   private final AtomicInteger percentComplete;

   public LongRunningProcess(AtomicInteger percentComplete) {
       this.percentComplete = percentComplete;
   }

   public void run() {
       for (int i = 0; i < 100; i++) {
       Thread.sleep(1000);
       percentComplete.incrementAndGet();
   }
}