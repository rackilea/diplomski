int sleepTime = 10000;
Thread background;
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.splash);

background = new Thread() {
    public void run() {

        try {
            sleep(sleepTime);


            Intent i;

           i=new Intent(getBaseContext(),Activity8.class);


            startActivity(i);

            finish();

        } catch (Exception ex) { }

    }
};

 if (connect.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTED || connect.getNetworkInfo(0).getState() == android.net.NetworkInfo.State.CONNECTING || connect.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTING ||
  connect.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
   network = true;
  }


   if (network == true) {
       sleepTime = 2000;
       background.interrupt();
       background.start();
   } else {
       sleepTime = 10000;
       background.interrupt();
       background.start();
   }