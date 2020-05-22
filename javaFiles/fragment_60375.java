public class SubscribeActivty extends Activity {

    InputStream is = null;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtAge;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private Button btnSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        edtFirstName = (EditText) findViewById(R.id.edtFirstName);
        edtLastName = (EditText) findViewById(R.id.edtLastName);
        edtAge = (EditText) findViewById(R.id.edtAge);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtConfirmPassword = (EditText) findViewById(R.id.edtConfirmPassword);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @SuppressLint("NewApi")
            @Override
            public void onClick(View view) {

                boolean isValid = true;
                if (edtFirstName.getText().toString().length() <= 0) {
                    edtFirstName.setError("Value  Required");
                    isValid = false;
                } else if (!edtFirstName.getText().toString().matches("[a-zA-Z ]+")) {
                    edtFirstName.setError("Accept Alphabets Only.");
                    isValid = false;
                }

                if (edtLastName.getText().toString().length() <= 0) {
                    edtLastName.setError("Value  Required");
                    isValid = false;
                } else if (!edtLastName.getText().toString().matches("[a-zA-Z ]+")) {
                    edtLastName.setError("Accept Alphabets Only.");
                    isValid = false;
                }

                if (edtEmail.getText().toString().length() <= 0) {
                    edtEmail.setError("Value  Required");
                    isValid = false;
                } else if (!isEmailValid(edtEmail.getText().toString())) {
                    edtLastName.setError("Invalid Email.");
                    isValid = false;
                }

                if (edtAge.getText().toString().length() <= 0) {
                    edtAge.setError("Value  Required");
                    isValid = false;
                } else if (!edtAge.getText().toString().matches("[0-9 ]+")) {
                    edtAge.setError("Accept Numbers Only.");
                    isValid = false;
                }

                if (edtPassword.getText().toString().length() <= 0) {
                    edtPassword.setError("Value  Required");
                    isValid = false;
                }

                if (edtConfirmPassword.getText().toString().length() <= 0) {
                    edtConfirmPassword.setError("Value  Required");
                    isValid = false;
                } else if (!edtConfirmPassword.getText().toString().equals(edtPassword.getText().toString())) {
                    edtConfirmPassword.setError("Password Mismatch.");
                    isValid = false;
                }


                if (isValid) {
                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                    nameValuePairs.add(new BasicNameValuePair("firstname", edtFirstName.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("lastname", edtLastName.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("age", edtAge.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("email", edtEmail.getText().toString()));
                    nameValuePairs.add(new BasicNameValuePair("password", edtPassword.getText().toString()));

                    submitDataOnServer(nameValuePairs);
                }
            }

        });

    }

    public void submitDataOnServer(final ArrayList<NameValuePair> nameValuePairs){
        new AsyncTask<Void,Void,String>(){
            @Override
            protected String doInBackground(Void... params) {
                try {
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("localhost/Android/Insert.php");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();

                    Log.e("log_tag", "connection success ");
                    Toast.makeText(getApplicationContext(), "Subscription Successfull.Thank You for Subscribing you have now been added to our Mailing Lists", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.e("log_tag", "Error in http connection " + e.toString());
                    Toast.makeText(getApplicationContext(), "Connection fail", Toast.LENGTH_SHORT).show();
                }
                try {

                    BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                    }
                    is.close();

                    return sb.toString();
                } catch (Exception e) {
                    Log.e("log_tag", "Error converting result " + e.toString());
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
                try {
                    JSONObject json_data = new JSONObject(result);
                    CharSequence w = (CharSequence) json_data.get("result");

                    Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    Log.e("log_tag", "Error parsing data " + e.toString());
                    Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
                }
            }
        }.execute();
    }


    public boolean isEmailValid(final String mailAddress) {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(mailAddress);
        return matcher.matches();
    }
}