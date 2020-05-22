@WebListener
public class ChatPushService implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
          final List<AsyncContext> watchers = new  ArrayList<AsyncContext>();
         sce.getServletContext().setAttribute("watchers", watchers);
          // store new messages not published yet
         Queue<String> messages = new ConcurrentLinkedQueue<String>();
         sce.getServletContext().setAttribute("messages", messages);
         new chatManager(sce.getServletContext()).start(); //START DAEMON

      }
}
public class ChatManager implements Runnable
{
ServletContext servletCtx;
public ChatManager(ServletContext ctx)
{
     this.servletCtx = ctx;
}
public void run()
{
         List<AsyncContext> watchers = (List<AsyncContext>) servletCtx.getAttribute("watchers");
     Queue<String> messages = (Queue<String>)appScope.getAttribute("messages");
     Executor messageExecutor = Executors.newCachedThreadPool(); 
         final Executor watcherExecutor = Executors.newCachedThreadPool();
         while(true)
          {      

             if(!messages.isEmpty()) 
             {
                 System.out.println("notEmpty");
                String message =  messages.poll(); 
                messageExecutor.execute(new Runnable(){

                    @Override
                    public void run() {
                         for(final AsyncContext aCtx : watchers){
                             watcherExecutor.execute(new Runnable(){

                                 @Override
                                    public void run() {
                                       try {
                                        aCtx.getResponse().getWriter().print("brrrrr");
                                    } catch (IOException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                    }
                                 }
                             });
                         }
                    }
             });
          }
    }

}

}