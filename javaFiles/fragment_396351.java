public class FacebookLoginActivity extends AppCompatActivity{

private CallbackManager callbackManager;
private LoginButton loginButton;
private String FB_TOKEN;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signin);
    callbackManager = CallbackManager.Factory.create();
    loginButton = (LoginButton) findViewById(R.id.login_button);
    loginButton.setReadPermissions("public_profile", "user_friends", "email", "user_birthday");
    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {

            /**
             * HERE YOU CAN GET YOUR FACEBOOK TOKEN!!!!
             **/
            FB_TOKEN=loginResult.getAccessToken().getToken();
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onError(FacebookException exception) {
        }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    callbackManager.onActivityResult(requestCode, resultCode, data);
}

}