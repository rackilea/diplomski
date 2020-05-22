public interface HttpRequestResponse {
    public void onSuccess(HttpResponse response);
    public void onException(Exception exception); 
}     


class HttpRequestResponseHandler {

   private ActionItem action;
   private HttpRequestResponse hrr;
   private Executor executor; 

   public enum ActionItem {
      LOGIN_REQUEST ,
      REGISTRATION_REQUEST            
   } 

   public HttpRequestResponseHandler(ActionItem action, HttpRequestResponse hrr) {
      this.action = action;
      this.hrr = hrr;       
   }

   public void execute(){
     executor = new Executor();
     executor.execute();       
   }

   private class Executor extends AsyncTask<Void,Void,Void> {

      @Override
      public Void doInBackground() {
         switch(action) {

            case LOGIN_REQUEST : doLogin();
                                 break;   

            case REGISTRATION_REQUEST : doRegistration();
                                        break; 
         }
      }
   }

   private void doLogin() {

      HttpResponse response = null;
      Exception exception = null;
      try {
         response = makeHttpRequestHere();
      } catch (Exception e) {
         exception = e;
      }

      if(exception != null) {
         hrr.onException(exception);
      } else {
         hrr.onSuccess(response);
      }

   }   

}