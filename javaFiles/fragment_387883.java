public class JSONExampleActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        new GetSmsTask().execute("http://iatek.eu/sys/getsms.php");
       }   

    private class GetSmsTask extends AsyncTask<String, Void, JSONObject> {
     protected JSONObject doInBackground(String... urls) {
     JSONObject obj = null;
     try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(url[0]);
            HttpResponse response = httpclient.execute(httppost);           
            String jsonResult = inputStreamToString(response.getEntity()
                                                   .getContent()).toString();                      
            obj = new JSONObject(jsonResult);
        } 
        catch (JSONException e) {
            e.printStackTrace();
        } 
        catch (ClientProtocolException e) {
            e.printStackTrace();
        } 
        catch (IOException e) {
            e.printStackTrace();
        }

        return obj;
     }

     protected void onPostExecute(JSONObject obj) {
      JSONArray jsonArray = obj.getJSONArray("posts");

       JSONObject childJSONObject = jsonArray.getJSONObject(3);
         String username = childJSONObject.getString("username");
         String sms = childJSONObject.getString("sms");
         String fcat = childJSONObject.getString("fcat");
         textView.setText(""+sms+"--" + username);
     }
 }

}