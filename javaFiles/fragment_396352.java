public class FacebookLoginActivity extends AppCompatActivity{

private CallbackManager callbackManager;
private Button loginButton;
private String FB_TOKEN;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_signin);
    callbackManager = CallbackManager.Factory.create();
    loginButton = (Button) findViewById(R.id.login_button);
    LoginManager.getInstance().registerCallback(callbackManager,
            new FacebookCallback<LoginResult>() {
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
                    Log.e("onError", exception.getMessage());
                }
            });
    loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(FacebookLoginActivity.this, Arrays.asList("public_profile", "user_friends", "email"));
            }
    });
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    callbackManager.onActivityResult(requestCode, resultCode, data);
}

}