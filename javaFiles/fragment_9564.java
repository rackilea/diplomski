public class Login extends AsyncTask<String, Boolean, Boolean> {

  private LoginListener listener;

  public Login(Application application, LoginListener listener){
    repository = new Repository(application);
    this.listener = listener;
  }

  @Override
  protected Boolean doInBackground(String... body){
    try {
        user = repository.getUser(body[0], body[1]);
        if (user != null)
            return true; //wont work
        else {
            return false;
        }
    }
    catch(Exception e){
        return null;
    }
  }

  protected void onPostExecute(Boolean result) {
   listener.onLoginPerformed(result)
  }



  public static interface LoginListener{
    public void onLoginPerformed(Boolean result);
  }
}