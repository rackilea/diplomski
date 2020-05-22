public class Register extends Activity {

    // "private" means it can only be accessed from this class
    private String myLat = null; // ** Declare myLat
    private String myLon = null; // ** Declare myLon


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText email_id = (EditText)  findViewById(R.id.email_id) ;
        final EditText name = (EditText) findViewById(R.id.name);
        final EditText password = (EditText) findViewById(R.id.password);
        Button button = (Button) findViewById(R.id.button1) ;



        //generate GCM id
        GCMRegistrar.checkDevice(this);
        GCMRegistrar.checkManifest(this);
        final String regId = GCMRegistrar.getRegistrationId(this);
        if (regId.equals("")) {
          GCMRegistrar.register(this, "12356");

        } else {
        String TAG = null;
        Log.v(TAG, regId);

        }
        //generate GCM id ended
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 
        //get current location

        LocationManager manager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        LocationListener listner = new LocationListener() {

            @Override
            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderEnabled(String arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onProviderDisabled(String arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onLocationChanged(Location location) {
                double myLonDouble = location.getLongitude();
                myLon = Double.toString(myLonDouble); // ** Define myLon
                double myLatDouble = location.getLatitude();
                myLat = Double.toString(myLatDouble); // ** Define myLat

            }
        };
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, listner);



        //end get current location

        button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {
        // TODO Auto-generated method stub
        // ** Check if they have been defined
        if (myLat == null || myLon == null)
            return;

        //postData();
          HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://xyz.com/folder/register.php");

            try {
            // Add your data
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
            nameValuePairs.add(new BasicNameValuePair("email", email_id.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("name", name.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("password", password.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("regid", regId));
            nameValuePairs.add(new BasicNameValuePair("uid", "2"));
            nameValuePairs.add(new BasicNameValuePair("lat",myLat ));
            nameValuePairs.add(new BasicNameValuePair("lon",myLon));
               httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            // Execute HTTP Post Request
               //Toast.makeText(this, resId, duration)
            HttpResponse response = httpclient.execute(httppost);

            } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            } catch (IOException e) {
            // TODO Auto-generated catch block
            }

        }
    });

    }


}