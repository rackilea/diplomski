public class MyActivity extends Activity {
  public interface AuthCallback {
    void onAuthResult(String token);
  }

  private String authenticate(AuthCallback callback) {
    // ...
    String responseObjectAccessToken = responseObject.getString("accesstoken");
    callback.onAuthResult(responseObjectAccessToken)
    // ...
  }

  public void doSomething(View v) {
    authenticate((token) -> {
      // do something with token
    });
  }

  // ...

}