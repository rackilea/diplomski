public class LoginActivity extends Activity implements OnClickListener {

    // flag for Internet connection status
    Boolean isInternetPresent = false;

   // Connection detector class
   ConnectionDetector cd;

   EditText username, password;
   Button login;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

      // creating connection detector class instance
    cd = new ConnectionDetector(getApplicationContext());

    /**
     * Check Internet status button click event
     * */

    username = (EditText) findViewById(R.id.username_et);
    password = (EditText) findViewById(R.id.password_et);

    login = (Button) findViewById(R.id.login_bt);
    login.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {


            // get Internet status
            isInternetPresent = cd.isConnectingToInternet();

            // check for Internet status
            if (isInternetPresent) {

                ***********************************************
                I moved your code to show a dialog to the beginning of the
                if block where you have internet. I also changed your dialog
                to a Toast message, as others have suggested. Dialog is a little
                too heavy for this in my opinion.
                ***********************************************

                 // Internet Connection is Present
                // make HTTP requests
                // showAlertDialog(LoginActivity.this, "Internet Connection",
                //         "You have internet connection", true);
                Toast
                .makeText(this, "You have internet connection", Toast.LENGTH_LONG)
                .show();

                ***********************************************
                Assuming that your isConnectingToInternet method returns 
                the correct value, within this if statement, you know that
                you have a valid Internet connection. Go ahead and fire offf
                your AsyncTask here.                

                I moved this code from after your if / else statement to within the
                if / else statement once you verify that the device has an Internet
                connection. AGAIN: This is assuming that your isConnectingToInternet
                returns a proper value. I did not look at that code.
                **********************************************

                String name = username.getText().toString();
                String pass = password.getText().toString();
                new AttemptLogin().execute(name, pass);

            } else {

                ***********************************************
                This logic remains the same. Think about it:
                If the user doesn't have Internet connection, you can't make a login
                request.
                ***********************************************

                // Internet connection is not present
                // Ask user to connect to Internet
                showAlertDialog(LoginActivity.this, "No Internet Connection",
                        "You don't have internet connection.", false);
            }

        }


        public void showAlertDialog(Context context, String title, String message, Boolean status) {
            AlertDialog alertDialog = new AlertDialog.Builder(context).create();

            // Setting Dialog Title
            alertDialog.setTitle(title);

            // Setting Dialog Message
            alertDialog.setMessage(message);

            // Setting alert dialog icon
            alertDialog.setIcon((status) ? R.drawable.success : R.drawable.fail);

            // Setting OK Button
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });

            // Showing Alert Message
            alertDialog.show();
        }

    });

}


private class AttemptLogin extends
        AsyncTask<String, Integer, String> {

    int success;
    String message = " ", _username, _password;

    @Override
    protected String doInBackground(String... args) {
        _username = args[0];
        _password = args[1];

        try {
            Map<String, String> params = new HashMap<String, String>();
            params.put("tag", "login");
            params.put("username", _username);
            params.put("password", _password);


            HttpUtility.sendPostRequest(params);


            String response = HttpUtility.readRespone();

            JSONObject jObj = null;

            try {

                jObj = new JSONObject(response);

                success = jObj.getInt("success");
                message = jObj.getString("message");


            } catch (JSONException e) {
                Log.e("JSON Parser", "Error parsing data" + e.toString());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        HttpUtility.disconnect();
        return message;

    }

    protected void onPostExecute(String status) {

        if (status != null) {

            Toast.makeText(getBaseContext(), status, Toast.LENGTH_LONG).show();

            if (success == 1) {
                SharedPreference.store(getApplicationContext(), _username, _password);
                startActivity(new Intent(getBaseContext(), DashboardActivity.class));





            }
        }
    }
}