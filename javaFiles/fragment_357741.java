@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.e(LOG_TAG, "Start Repeat Timer");

        Thread thInitializer = new Thread() {
            @Override
            public void run() {
                TimerTask task = new RepeatingTask(); // here will block until is readed from socket, but will not block the UI

                //after read is done you can set  breakpoint to next statement, but it will repet the run method of the RepeatingTask in each 3 sec
                Timer timer = new Timer();
                timer.scheduleAtFixedRate(task, 0, 3000);
                Log.e(LOG_TAG, "Started Repeat Timer");
            }
        };
        thInitializer.start();
        // UI initialization is done, background thread is running an trying to initialize the network stuff        
    }