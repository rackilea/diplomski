public class MainActivity extends Activity {

         JSONArray jArray;
         String result = null;
         InputStream is = null;
          StringBuilder sb=null;

         @Override
        public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       new httpRequest().execute();

        }


         private class httprRequest extends AsyncTask<String, Integer, String>{

                @override
                public String doInBackground(String.... params){
                   ArrayList<NameValuePair> nameValuePairs = new             ArrayList<NameValuePair>();
        //http post
          try{
           HttpClient httpclient = new DefaultHttpClient();
           HttpPost httppost = new HttpPost("http://www.steagu.ro/android/city.php");
           httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
           HttpResponse response = httpclient.execute(httppost);
           if (response.getStatusLine().getStatusCode() != 200) {
               Log.d("MyApp", "Server encountered an error.");

              }
          HttpEntity entity = response.getEntity();
          is = entity.getContent();
          }catch(Exception e){
          //e.printStackTrace();
          Log.e("log_tag", "Error in http connection: "+e.toString());
           }

                }
              }

           }
       }