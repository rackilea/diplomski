private void sendPost() throws Exception {

    //Below is a good tutorial , how to post json data
    //http://hmkcode.com/android-send-json-data-to-server/

    final String REGISTRATION_ID ="APA91bHH4iNCFdWUIXSHRXV3hsBeF8IU0ZElts9AXaHItDfRdRld-kwkVx69EFYZePPuLOW1hTkUCmAwyTeGdoirr25KJ3RG1AikGbBzsvqaPCLLz9YYCwPDuB6xUupVKmllNoTn2v0BRTTkC6OS_i8zerATtBP3gg" ;
    final String API_KEY = "AIzaSyARQTvQ5pRYEbW-9V98uDHNnn10Rwffx18";



    String url = "https://android.googleapis.com/gcm/send";
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost(url);
    JSONObject mainData = new JSONObject();
    try {
        JSONObject data = new JSONObject();
        data.putOpt("message1", "test msg");
        data.putOpt("message2", "testing..................");
        JSONArray regIds = new JSONArray();
        regIds.put(REGISTRATION_ID);
        mainData.put("registration_ids", regIds);
        mainData.put("data", data);
        Log.e("test","Json data="+mainData.toString());
    } catch (JSONException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    StringEntity se = new StringEntity(mainData.toString());
    post.setEntity(se);
    post.addHeader("Authorization", "key="+API_KEY);
    post.addHeader("Content-Type", "application/json");
    HttpResponse response = client.execute(post);
    Log.e("test" ,
            "response code ="+Integer.toString(response.getStatusLine().getStatusCode()));
    BufferedReader rd = new BufferedReader(
            new InputStreamReader(response.getEntity().getContent()));
    StringBuffer result = new StringBuffer();
    String line = "";
    while ((line = rd.readLine()) != null)
    {
        result.append(line);
    }
    Log.e("test","response is"+result.toString());
}