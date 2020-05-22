@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //creating network variables that store wifi and cell networks
        myWifiNetwork = new forceWifiNetwork(this);


        try {
            myWifiNetwork.cellConnect();
            if (myWifiNetwork.mWifiNetwork == null) {
                Log.i("onCreate", "mWifiNetwork is null");
            } else {
                Log.i("onCreate", "mWifiNetwork is not null");
            }
        }catch(Exception e){
            Log.i("Error in onCreate","error creating network");
            e.printStackTrace();
        }


    }