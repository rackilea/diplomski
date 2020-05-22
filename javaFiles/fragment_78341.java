ArrayList<String> spinnerArray;
ArrayAdapter<String> spinnerArrayAdapter
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.popup);

    WayPointData = new SubscribedData<>();
    final Type WayPointType = new TypeToken<SubscribedData<WayPoint>>() {
    }.getType();


    // spinner element
    spin = (Spinner) findViewById(R.id.spinner);
    spinnerArray = new ArrayList<String>();
    spinnerArrayAdapter = new ArrayAdapter<String>
            (this, android.R.layout.simple_spinner_item,
           spinnerArray);
    spin.setAdapter(spinnerArrayAdapter);

    rosbridge = new RosbridgeListener("ws://10.24.204.231:9090");
    rosbridge.setOnDataReceivedListener(new RosbridgeMessageListener() {

        /**
         * a running thread that when the connection is made the data of the topic will serialize and deserialized java objects
         * to (and from) JSON.
         * @param msg
         */
        @Override
        public void onDataReceived(final String msg) {
            try {
                runOnUiThread(  new Runnable() {
                    @Override
                    public void run() {
                        try {
                            WayPointData = new Gson().fromJson(msg,WayPointType);
                            // modify below lines like
                            JSONObject mainObject = new JSONObject(msg); // add msg in JSONObject parameter
                            JSONObject msgObject = mainObject.getJSONObject("msg"); // get msgObject from main object
                            JSONArray wayPointJsonArray = msgObject.getJSONArray("waypoints"); // get wayPointJsonAarry from msg object
                            for (int i = 0; i < wayPointJsonArray.length(); i++) {
                                JSONObject wayPointJsonObject = wayPointJsonArray.getJSONObject(i);
                                // Parse name
                                String name = wayPointJsonObject.getString("name");
                                WayPoint wayPoint = new WayPoint();
                                wayPoint.name = name;

                               // here you have to add name to your spinner array
                               spinnerArray.add(name)
                            }
                           // After all your data added to arraylist you should notify adapter that data set changed
                           spinnerArrayAdapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                /** a msg that will display once the data is received **/
                Log.d("B9T", String.format("Received data: %s", msg));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    });


    spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int p, long id) {
            WayPoint wayPoint = (WayPoint) parent.getItemAtPosition(p);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
        }
    });

    /** a set of the waypoints popup window **/
    DisplayMetrics dm = new DisplayMetrics();
    getWindowManager().getDefaultDisplay().getMetrics(dm);

    int width = dm.widthPixels;
    int height = dm.heightPixels;

    getWindow().setLayout((int) (width * .6), (int) (height * .6));


  }
}