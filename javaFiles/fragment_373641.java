// Maybe this will help ... 
    private class JsonReadTask extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... params) {
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(params[0]);
    try {
        HttpResponse response = httpclient.execute(httppost);
        jsonResult = inputStreamToString(
        response.getEntity().getContent()).toString();

// LETS RETURN SOMETING ... 
        return jsonResult;
    }

    catch (ClientProtocolException e) {
           e.printStackTrace();
    } catch (IOException e) {
           e.printStackTrace();
      }
    return null;
 }