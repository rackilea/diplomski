//**** e.g.
class requestHandler extends AsyncTask<Object, Void, JSONArray> {
    // define a caller

    String requester;
    Application caller;
    YourEachActivityClass1 caller1;

    //create a Constructor for caller;
    public requestHandler (Application caller) {
        // TODO Auto-generated constructor stub
         this.caller = caller;
    }

    public requestHandler (YourEachActivityClass1 caller1) {
        // TODO Auto-generated constructor stub
         this.caller1 = caller1;
    }

    ///&& method doInBackground
    @Override
    protected JSONArray doInBackground(Object... params) {
          .....
          //your process is here
         //custom your returning jsonarray

    try {

    Context context = (Context) params[0];
    Log.i(TAG, "context :"+context.getClass().getSimpleName());

    requester = (Integer) params[1];

    String message = (String) params[2];

    String public= (String) params[3]

        String url = "http://www.someurl.com";

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);

        List<NameValuePair> urlParameters = requestHandlerHelper(params);
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(urlParameters);

        entity.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8"));
        post.setEntity(entity);

        HttpResponse response = client.execute(post);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

        Reader reader = new InputStreamReader(response.getEntity().getContent());

        int contentLength = (int) response.getEntity().getContentLength();
        Log.v(TAG, "Content Length DATA" + contentLength);
        char[] charArray = new char[contentLength];
        reader.read(charArray);

        String responseData = new String(charArray);
        JSONArray jsonResponse = new JSONArray(responseData);

        Globals.PUBLIC_KEY = String.valueOf(jsonResponse);

        return jsonResponse;

    } catch (ClientProtocolException e) {
        Log.i(TAG, "ClientProtocolException: ", e);
    } catch (UnsupportedEncodingException e) {
        Log.i(TAG, "UnsupportedEncodingException: ", e);
    } catch (IOException e) {
        Log.i(TAG, "IOException: ", e);
    } catch (JSONException e) {
        Log.i(TAG, "JSONException: ", e);
    }
    return null;

    }

    ////&& return JSONArray back to ur activity class here by pass in caller
    protected void onPostExecute(JSONArray jsonarray) {

        if(requester.equals("IM_Application"))
            caller.onBackgroundTaskCompleted(jsonarray);
        else if(requester.equals("IM_ACTIVITY_1"))
            caller1.onBackgroundTaskCompleted(jsonarray);
    }

}