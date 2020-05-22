public class LoActivity extends Activity {

    Intent i;
    Button signin;
    TextView error;
    CheckBox check;
    String name = "", pass = "";
    byte[] data;
    HttpPost httppost;
    StringBuffer buffer;
    HttpResponse response;
    HttpClient httpclient;
    InputStream inputStream;
    SharedPreferences app_preferences;
    List<NameValuePair> nameValuePairs;
    EditText editTextId, editTextP;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        signin = (Button) findViewById(R.id.signin);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextP = (EditText) findViewById(R.id.editTextP);
        app_preferences = PreferenceManager.getDefaultSharedPreferences(this);
        check = (CheckBox) findViewById(R.id.check);
        String Str_user = app_preferences.getString("username", "0");
        String Str_pass = app_preferences.getString("password", "0");
        String Str_check = app_preferences.getString("checked", "no");
        if (Str_check.equals("yes")) {
            editTextId.setText(Str_user);
            editTextP.setText(Str_pass);
            check.setChecked(true);
        }

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                name = editTextId.getText().toString();
                pass = editTextP.getText().toString();
                String Str_check2 = app_preferences.getString("checked", "no");
                if (Str_check2.equals("yes")) {
                    SharedPreferences.Editor editor = app_preferences.edit();
                    editor.putString("username", name);
                    editor.putString("password", pass);
                    editor.commit();
                }
                if (name.equals("") || pass.equals("")) {
                    Toast.makeText(Lo.this, "Blank Field..Please Enter", Toast.LENGTH_SHORT).show();
                } else {
                    new LoginTask().execute();
                }
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on clicks, depending on whether it's now
                // checked
                SharedPreferences.Editor editor = app_preferences.edit();
                if (((CheckBox) v).isChecked()) {
                    editor.putString("checked", "yes");
                    editor.commit();
                } else {
                    editor.putString("checked", "no");
                    editor.commit();
                }
            }
        });
    }

    public void Move_to_next() {
        startActivity(new Intent(LoActivity.this, QnActivity.class));

    }

    private class LoginTask extends AsyncTask<Void, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Show progress dialog here
        }
        @Override
        protected String doInBackground(Void... arg0) {
            try {
                httpclient = new DefaultHttpClient();
                httppost = new HttpPost("http://abc.com/register.php");
                // Add your data
                nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("UserEmail", name.trim()));
                nameValuePairs.add(new BasicNameValuePair("Password", pass.trim()));
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                // Execute HTTP Post Request
                response = httpclient.execute(httppost);
                inputStream = response.getEntity().getContent();

                data = new byte[256];

                buffer = new StringBuffer();
                int len = 0;
                while (-1 != (len = inputStream.read(data))) {
                    buffer.append(new String(data, 0, len));
                }

                inputStream.close();
                return buffer.toString();
            } catch (Exception e) {
                e.printStackTrace();

            }
            return "";
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Hide progress dialog here

            if (buffer.charAt(0) == 'Y') {
                Toast.makeText(LoActivity.this, "login successfull", Toast.LENGTH_SHORT).show();
                Move_to_next();
            } else {
                Toast.makeText(LoActivity.this, "Invalid Username or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}