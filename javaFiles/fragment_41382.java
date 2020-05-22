protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    intent = getIntent();
    setContentView(R.layout.activity_display_message);
    message = intent.getStringArrayExtra(MainActivity.EXTRA_MESSAGE);
    newtext = (TextView)findViewById(R.id.TextView1);
    userName = message[0];
    serverIP = message[1];
    sendConnectionRequest ();
    mHandler = new Handler();   // Handler to update UI  
                                // This is being created in the main thread
                                // so everything posted will be posted to 
                                // the main thread

    mUpdate.start();            // start thread to do something on the network 
                                //before updating the UI

}

public Thread mUpdate = new Thread() {
    public void run() {            
        try {
            while (!thread.interrupted()) {   
                final String line = in.readLine();
                Log.i("RESPONSE FROM SERVER", "S: Received Message: '" +line+ "'");

                // Define the UI change you want to make
                Runnable uiUpdate = new Runnable() {
                    public void run() {
                        // modify your UI here.
                        newtext.setText(line);
                    }
                };

                // post the UI change back to the main thread.
                mHandler.post(uiUpdate);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            Log.e("Error" , "Something Happen");    
        }
    }

    public void interrupt() {
        try {
            super.interrupt();
            in.close();
        }
        catch (IOException e) {}
    }
};