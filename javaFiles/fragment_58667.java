public class TcpConHandler{
Activity activity;

public TcpConHandler(Activity activity){
 this.activity=activity;
}
//...your code here..
public void imageUpdate() {
//...your code here...
     activity.runOnUiThread(new Runnable() {
       public void run() {
              // update imageView here...
          }
      });
}