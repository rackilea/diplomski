new SendRegisterationTask().execute();



private class SendRegistrationTask extends AsyncTask<String, String, String> {

    protected void onPreExecute() {
        // prepare the request
    }

    protected String doInBackground(String... aurl) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.******.**/register.php");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("name", strName));
            nameValuePairs.add(new BasicNameValuePair("email", strEmail));
            nameValuePairs.add(new BasicNameValuePair("password", strPassword));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);

            startActivityForResult(new Intent(view.getContext(),
                    RegFinishActivity.class), 0);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        // Do what you want after the request has been handled
    }
}