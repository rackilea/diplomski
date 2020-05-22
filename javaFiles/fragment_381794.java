public class MainActivity extends Activity{
    ..

    private Button btnLogin;
    ..

    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            btnLogin = (Button) findViewById(R.id.btnLogin);

            btnLogin.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View arg0) {
                                       try {
                         String param1 = "testParam1";
                         String param2 = "testParam2";
                                 new SyncHelper(MainActivity.this).execute("http://server.example.com/api", param1, param2); //this way, my activity waits of the answer
                               Log.d(TAG, "Finished: " + response);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            } catch (ExecutionException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // user didn't entered username or password
                            Toast.makeText(getApplicationContext(),
                                    "Done",
                                    Toast.LENGTH_LONG).show();
                        }
                    } catch (Exception e) {
                    }
                }
            });
        }





public class SyncHelper extends AsyncTask<String, Void, String>
{


..

    Context context;
    private ProgressDialog pd;
..

    public SyncHelper (Context c)
    {
         context = c;
    } 


@Override
        protected void onPreExecute() {
            pd = new ProgressDialog(context);
            pd.setTitle("Processing...");
            pd.setMessage("Please wait.");
            pd.setCancelable(false);
            pd.setIndeterminate(true);
            pd.show();
        }
        protected String doInBackground(String... url) {
            String response = "";
            try {
                response = getRequest(url[0], url[1], url[2]); //Here I make a HttpURLConnection
            } catch (IOException e) {
                e.printStackTrace();
            }
            return response;
        }


        protected void onPostExecute(String result) {

            // here you will be getting the response in String result.
                 if (pd.isShowing()) 
                            pd.dismiss();

        }
}