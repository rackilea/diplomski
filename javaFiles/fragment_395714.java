public class MyActivity extends Activity implements AuthCallback {
  @Override
  public void onAuthResult(String token) {
    // do something
  }

  // ...

  public void doSomething(View v) {
    authenticate(MyActivity.this); // <-- pass itself
  }
}