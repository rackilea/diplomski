public class LoginTask extends AsyncTask<void , void, void> {

private String user, password;
private LoginActivity loginActivity;

public LoginTask(LoginActivity loginActivity, String user, String password){
     this.loginActivity = loginActivity;
     this.user = user;
     this.password = password;
}
@Override
protected String doInBackground(Void... params) {
     //do all the networking here
}

protected void onPostExecute(Void results){
     super.onPostExecute(results);
     loginActivity.navigatetoMainActivity();
}
}