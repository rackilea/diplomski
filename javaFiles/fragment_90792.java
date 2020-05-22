public class SendTask extends AsyncTask<Void, Void, Boolean> {

    String responseString;

    @Override
    protected Boolean doInBackground(Void... params) {
        try {

            HttpClient http = new DefaultHttpClient();
            HttpPost post = new HttpPost("http://www.test.com");

            List<NameValuePair> data = new ArrayList<NameValuePair>();
            data.add(new BasicNameValuePair("phone", "value"));
            data.add(new BasicNameValuePair("name", "value"));
            data.add(new BasicNameValuePair("email", "value"));
            data.add(new BasicNameValuePair("comments", "value"));
            post.setEntity(new UrlEncodedFormEntity(data));

            HttpResponse response = http.execute(post);
            responseString = new BasicResponseHandler().
                                 handleResponse(response); // Basic handler
            return true;
        }
        catch (ClientProtocolException e) {
            // do something useful to recover from the exception
            // Note: there may not be anything useful to do here
        }
        catch (IOException e) {
            // do something useful to recover from the exception
            // Note: there may not be anything useful to do here
        }           
        return false;
    }
    @Override
    protected void onPostExecute(Boolean success) {
        // TODO: Do something more useful here
        if (success) {
            Toast.makeText(MainActivity.this, "Success: " + responseString, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Failed", Toast.LENGTH_LONG).show();
        }
    }
}