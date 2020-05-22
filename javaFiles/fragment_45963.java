public class MainActivity extends Activity {

private AsyncTask<JSONObject, JSONObject, JSONObject> result;
     JSONObject jsonResponse = null;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    try {
        JSONObject toSend = new JSONObject();
        toSend.put("id", "2151");

        JSONTransmitter transmitter = new JSONTransmitter();
        result=transmitter.execute(new JSONObject[] {toSend});

    } catch (JSONException e) {
        e.printStackTrace();
    }

}

public class JSONTransmitter extends AsyncTask<JSONObject, JSONObject, JSONObject> {

    String url = "Some url";

    @Override
    public JSONObject doInBackground(JSONObject... data) {
        JSONObject json = data[0];
        HttpClient client = new DefaultHttpClient();
        HttpConnectionParams.setConnectionTimeout(client.getParams(), 100000);
        JSONObject jsonResponse = null;
        HttpPost post = new HttpPost(url);
        try {
            StringEntity se = new StringEntity(json.toString());
            post.addHeader("content-type", "application/json");
            post.setEntity(se);

            HttpResponse response;
            response = client.execute(post);
            String resFromServer = org.apache.http.util.EntityUtils.toString(response.getEntity());

            jsonResponse=new JSONObject(resFromServer);
            Log.i("Response from server", jsonResponse.getString("EventId"));

        } catch (Exception e) { e.printStackTrace();}

        return jsonResponse;
    }
    @Override
    protected void onPostExecute(JSONObject jsonResponse) {
    // do whatever you want to do  with jsonResponse

    }
}

}