class RequestTask extends AsyncTask<String, String, String> {
    String response;
    ProgressDialog dialog;

    @Override
    protected String doInBackground(String... params) {
        try {
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(params[0]); // or HttpPost if you need

            ResponseHandler<String> resHandler = new BasicResponseHandler();
            response = httpClient.execute(httpGet, resHandler);
       } catch (Exception e) {
           System.out.println("E: " + e);
       }

       return null;
    }

    @Override
    protected void onPreExecute() {
        dialog = new ProgressDialog(MainActivity.this);
        dialog.setMessage("Loading...");
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        dialog.dismiss();
        super.onPostExecute(result);
    }
}