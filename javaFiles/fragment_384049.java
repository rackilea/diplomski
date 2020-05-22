public class LoginActivity extends Activity implements AsyncTaskCompleteListener<String> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        LoadURL loadUrl = new LoadURL(LoginActivity.this);
        loadUrl.execute(...);
    }

    @Override
    public void onTaskComplete(String result, int number) {...}
}