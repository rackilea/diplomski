public class Attendance extends Activity {


    static InputStream iStream = null;
    static JSONArray jArray = null;
    static String json = "";

    @Override
    public void onCreate(Bundle savedInstanceState)

    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button details = (Button) findViewById(R.id.mydetails);

        details.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings({ "deprecation", "unused" })
            public void onClick(View view) {

                new makeHTTPRequest().execute();

            }
        });
    }

    private class makeHTTPRequest extends AsyncTask<String, String, String> {

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub

        String result = null;
        InputStream is = null;

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://frndz4ever.com/glbsim/attend.php");
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();

            Log.i("log_tag", "connection success ");
        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
            // Toast.makeText(getApplicationContext(), "Connection fail",
            // Toast.LENGTH_SHORT).show();

        }
        // convert response to string
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, "iso-8859-1"), 8);
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result = sb.toString();
        } catch (Exception e) {
            Log.e("log_tag", "Error converting result " + e.toString());

        }

        return result;
    }

    protected void onPostExecute(String result) {

        // parse json data
        try {

            JSONArray jArray = new JSONArray(result);
            String re = jArray.getString(jArray.length() - 1);

            int flag = 1;

            for(int i=0;i<jArray.length();i++){

                    JSONObject json_data = jArray.getJSONObject(0);

                    Log.i("log_tag",
                            "Index: "+ i + " Roll_no: " + json_data.getInt("Roll_no")
                                    + ", Subjects: "
                                    + json_data.getString("Subject")
                                    + ", Present: "
                                    + json_data.getInt("Present")
                                    + ",Absent: "
                                    + json_data.getInt("Absent"));

            }

                    // Perform any required actions here


        } 
        catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
            Toast.makeText(getApplicationContext(), "JsonArray fail",  Toast.LENGTH_SHORT).show();
        }

    }

}