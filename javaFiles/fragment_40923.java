TextView gettoken;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    if (android.os.Build.VERSION.SDK_INT > 9) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    this.gettoken = (TextView)findViewById(R.id.lblToken);

    new AsyncTask<Void, Void, Void>() {

        String token;

        @Override
        protected Void doInBackground(Void... params) {

            // Creating new JSON Parser
            JSONParser jParser = new JSONParser();
            // Getting JSON from URL
            JSONObject json = jParser.getJSONFromUrl(url);
            try {
                // Getting JSON Array
                token = json.getJSONArray(TAG_RESULT);
                JSONObject c = token.getJSONObject(0);
                // Storing  JSON item in a Variable
                token = c.getString(TAG_TOKEN);
                //Importing TextView

            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            //Set JSON Data in TextView
            gettoken.setText(token);
        }
    }.execute();

 }