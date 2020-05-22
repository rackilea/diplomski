public class Results extends HttpServlet{
...
  private Thread t;
  private volatile String myResult;
...
  protected void doPost(...){
  ...
      t = new Thread(){
        public void run(){
          myResult = outsideMethod1(data);
        }
      }
      t.start();
  }
}