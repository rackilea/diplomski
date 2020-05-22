class PostAsync extends AsyncTask<String, String, JSONObject> {

    JSONParser jsonParser = new JSONParser();

    private ProgressDialog pDialog;

    private static final String LOGIN_URL = "http://www.example.com/login.php.php";

    @Override
    protected void onPreExecute() {
        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Attempting login...");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(true);
        pDialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... args) {

        try {

            List<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("email", args[0]));
            params.add(new BasicNameValuePair("password", args[1]));

            Log.d("request", "starting");

            JSONObject json = jsonParser.makeHttpRequest(
                    LOGIN_URL, "POST", params);

            if (json != null) {
                Log.d("JSON result", json.toString());

                return json;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    protected void onPostExecute(JSONObject json) {

        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }

        if (json != null) {
            try {
                Boolean success = json.getBoolean("ok");
                if (success) {
                    Log.d("LOGIN","LOGIN SUCCESSFUL");
                    finish();
                } else {
                    String err_msg = json.getString("error");
                    Toast toast = Toast.makeText(MainActivity.this.getApplicationContext(), err_msg, Toast.LENGTH_LONG);
                    toast.show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

}