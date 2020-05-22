public class LoaderServlet extends HttpServlet {

  private Map<String,Thread> threadMap = new HashMap<>();

  protected void doPost(..) {
    String sessionId = request.getSesion().getId();
    Thread u = null;
    if(threadMap.containsKey()) {
        u = threadMap.get(sessionId);
    } else {
       u = new Thread(...);
       threadMap.put(sessionId, u);
    }
    // use thread 'u' as you wish
  } 

}