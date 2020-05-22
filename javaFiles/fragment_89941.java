private void MyMethod() {
    HttpClient httpclient = new DefaultHttpClient();
    HttpPost httppost = new HttpPost("http://www.website.com/welcome.php");
    try {
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("id", url));

        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        // Execute HTTP Post Request

        ResponseHandler<String> responseHandler = new BasicResponseHandler();
        final String response = httpclient.execute(httppost, responseHandler);
        //String url=response;

        runOnUiThread(
            new Runnable() {
                @Override
                public void run() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("My Title");
                    builder.setMessage(response);
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.show();
                    TextView messageText = (TextView)dialog.findViewById(android.R.id.message);
                    messageText.setGravity(Gravity.CENTER);
                }
            }
        );

    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}