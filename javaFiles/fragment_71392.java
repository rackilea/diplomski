package hk.hoome.www.mobilehoome;

public class database_connector extends AsyncTask<Void,Void, Void> {

//String mode;
HttpResponse response;
String sql;
JSONArray jsonArray;
searchPage searchPage;
private Runnable activityCallback;

public void setCallback(Runnable callback) {
    this.activityCallback = callback;
}

public database_connector(String sql, searchPage searchPage){
    //this.mode = mode;
    this.sql = sql;
    this.searchPage = searchPage;
    jsonArray = new JSONArray();
}

@Override
protected Void doInBackground(Void... params) {
    connect();
    publishProgress();
    return null;
}

protected void onPostExecute(Void result) {

    if(activityCallback != null) {
        activityCallback.run();
    }
}


@Override
protected void onProgressUpdate(Void... values) {

}

public void connect() {
    List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>(1);
    nameValuePair.add(new BasicNameValuePair("sql", sql));
    //nameValuePair.add(new BasicNameValuePair("mode", mode));
    try {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("http://www.hoome.hk/hoomeMobileApps/connectDB.php");
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair, "UTF-8"));
        response = httpClient.execute(httpPost);
        HttpEntity httpEntity  = response.getEntity();
        String entityResponse  = EntityUtils.toString(httpEntity);
        Log.e("Entity Response ", entityResponse.substring(2));
        jsonArray = new JSONArray(entityResponse.substring(2));

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (JSONException e) {
        e.printStackTrace();
    }
}



public JSONArray getJsonArray(){
    return jsonArray;
}
}