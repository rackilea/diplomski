// use async task like this .this will solve ur problem


Class A{
 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                MainActivity.this.runOnUiThread(new Runnable() {

                    public void run() {
                      new RequestLogInFromServer().execute();

                    }
                });
            }
        });

    }




      public class RequestLogInFromServer extends AsyncTask<Object, Object, Object>
        {


            @Override
            protected Object doInBackground(Object... params)
            {

                String responsearray[] = new String[2];
            //JSONObject jsonResponse = null;


            // Create a new HttpClient and Post Header
            HttpClient httpClient = new DefaultHttpClient();
            HttpPost httpPost = new HttpPost("http://shopstable.turkcell.com.tr/timme/getPerosConfig.do");
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            try {
                // Add your data

          in case if u want to pass any data to server else leave it

                List<NameValuePair> signinDetails = new ArrayList<NameValuePair>();
                signinDetails.add(new BasicNameValuePair("name",uname));
                signinDetails.add(new BasicNameValuePair("pass",pwd));

                httpPost.setEntity(new UrlEncodedFormEntity(signinDetails));

                // Execute HTTP Post Request
                HttpResponse httpResponse = httpClient.execute(httpPost);
                Log.v("Post Status", "Code: "
                        + httpResponse.getStatusLine().getStatusCode());
                responseCode = httpResponse.getStatusLine().getStatusCode();
                Log.e("responseBody", String.valueOf(responseCode));
                responsearray[0]=String.valueOf(responseCode);
                switch(responseCode){
                case 200:

                Log.e("responseCode", String.valueOf(responseCode));
                HttpEntity entity = httpResponse.getEntity();
                Log.e("entity", String.valueOf(entity));
                if (entity != null) {

                    responsearray[1] = EntityUtils.toString(entity);
                    Log.e("responsearray", String.valueOf(responsearray));


                /*  Log.e("responseBody", String.valueOf(responseBody));
                    JSONTokener jsonTokener = new JSONTokener(responseBody);
                    jsonResponse = new JSONObject(jsonTokener);
                    Log.e("finalResult", String.valueOf(jsonResponse));

                    JSONObject response = jsonResponse.getJSONObject("response");

                    // Getting String inside response object
                    String status = response.getString("status");
                    String message = response.getString("message");
                    Log.e("status", String.valueOf(status));
                    Log.e("message", String.valueOf(message));
                    */

                  } // if (entity != null)  end
                break;                  
                case 503:               
                    responsearray[1]="";

                break;

                default:
                    responsearray[1]="";            
                    break;


                }//switch end

            } catch (ClientProtocolException cpeExp) {
                // TODO Auto-generated catch block
            } catch (Exception allExp) {
                // TODO Auto-generated catch block
            }

            return responsearray;

            }


            @Override
            protected void onPostExecute(Object result) 
            {


                super.onPostExecute(result);
            }

            @Override
            protected void onPreExecute() {

                progressDialog = ProgressDialog.show(SignInActivity.this, "", "Please wait");
                super.onPreExecute();
            }

        }
} //close class A