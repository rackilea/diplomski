private class DownloadOperation extends AsyncTask<Void, Void, String> {
    String uname = "";
    String email   = "";
    String password   = "";
    String confirmpass   = "";
    String phone = "";

     @Override
protected void onPreExecute() {
    super.onPreExecute();
    // Get user defined values
    uname = username.getText().toString();
    email   = mail.getText().toString();
    password   = pass.getText().toString();
    confirmpass   = cpass.getText().toString();
    phone = phn.getText().toString();
}

@Override
protected String doInBackground(Void... params) {
        String response = "";
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost("http://www.rgbpallete.in/led/api/signup");
        HttpEntity httpEntity = null;
        HttpResponse httpResponse = null;
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(4);
            nameValuePairs.add(new BasicNameValuePair("uname", uname));
            nameValuePairs.add(new BasicNameValuePair("pass", password));
            nameValuePairs.add(new BasicNameValuePair("email", email));
            nameValuePairs.add(new BasicNameValuePair("phone", phone));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            httpclient.execute(httppost);
            httpResponse = httpClient.execute(httpPost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
            } catch (IOException e) {
            e.printStackTrace();
        }
        httpEntity = httpResponse.getEntity();
        response = EntityUtils.toString(httpEntity);
        return response;
}

@Override
protected void onPostExecute(String result) {
    super.onPostExecute(result);
    Log.d("tag", "Result:\n" + result);
}}