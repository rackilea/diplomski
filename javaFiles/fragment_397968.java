public class LoginActivity extends ActionBarActivity{

@Override
protected void onActivityResult(int requestCode, int responseCode, Intent data)
{
    super.onActivityResult(requestCode, responseCode, data);
    callbackManager.onActivityResult(requestCode, responseCode, data);
}

@Override
protected void onCreate(Bundle savedInstanceState)
{
    super.onCreate(savedInstanceState);
    FacebookSdk.sdkInitialize(this.getApplicationContext());
    setContentView(R.layout.activity_login);
    callbackManager = CallbackManager.Factory.create();
    loginButton = (LoginButton) findViewById(R.id.loginFaceBook_button);
    List<String> permissionNeeds = Arrays.asList("user_photos", "email", "user_birthday", "public_profile");
    loginButton.setReadPermissions(permissionNeeds);

    loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>()
    {
        @Override
        public void onSuccess(LoginResult loginResult)
        {
            System.out.println("onSuccess");
            GraphRequest request = GraphRequest.newMeRequest
                    (loginResult.getAccessToken(), new GraphRequest.GraphJSONObjectCallback()
                    {
                        @Override
                        public void onCompleted(JSONObject object, GraphResponse response)
                        {
                            // Application code
                            Log.v("LoginActivity", response.toString());
                            //System.out.println("Check: " + response.toString());
                            try
                            {
                                String id = object.getString("id");
                                String name = object.getString("name");
                                String email = object.getString("email");
                                String gender = object.getString("gender");
                                String birthday = object.getString("birthday");
                                System.out.println(id + ", " + name + ", " + email + ", " + gender + ", " + birthday);
                            }
                            catch (JSONException e)
                            {
                                e.printStackTrace();
                            }

                        }
                    });
            Bundle parameters = new Bundle();
            parameters.putString("fields", "id,name,email,gender, birthday");
            request.setParameters(parameters);
            request.executeAsync();
        }

        @Override
        public void onCancel()
        {
            System.out.println("onCancel");
        }

        @Override
        public void onError(FacebookException exception)
        {
            System.out.println("onError");
            Log.v("LoginActivity", exception.getCause().toString());
        }
    });
  }
}