public class PushNotification {

public void sentPushIntoAndroid(JSONArray device_token, String message)
        throws JSONException {


    HttpPost httppost = new HttpPost("https://android.googleapis.com/gcm/send");

    StringEntity stringentity = new StringEntity(generateJSONBodyForHTTPBody(device_token, message).toString(), "UTF-8");

    httppost.addHeader("Content-Type", "application/json");
    httppost.addHeader("Authorization", "key=AI**********Mo"");

    httppost.setEntity(stringentity);

    HttpClient httpclient = new DefaultHttpClient();
    HttpResponse response;
    try {
        response = httpclient.execute(httppost);

        HttpEntity entity = response.getEntity();

        String strresponse = null;
        if (entity != null) {
            strresponse = EntityUtils.toString(entity);

            displayLog("HTTP Response ", strresponse);
        }
    } catch (ClientProtocolException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

}

private JSONObject generateJSONBodyForHTTPBody(JSONArray device_token, String message) throws JSONException {

    JSONObject jObj = new JSONObject();
    jObj.put(CommonUtilities.REGISTRATION_ID, device_token);

    JSONObject dataJson = new JSONObject();

//NOTE:- In Client side, you have to retrieve below param by using getBundle().getString("id") like it. so it will retrieve the id and do for other params too like as i did for id.
    dataJson.put("id", "testingID");
    dataJson.put("type", "testingType");
    dataJson.put("imglink", "testingimgLink");
    dataJson.put("seolink", "testingseoLink");
    dataJson.put("msg", "Lata Bhulli");

    jObj.put("data", dataJson);

    displayLog("JSONObject", jObj.toString());

    return jObj;
}

private void displayLog(String tag, String message) {
    System.out.println(tag+" "+message);
}