private GPSTracker myGpsTracker;

 protected void onCreate(Bundle savedInstanceState) {
        myGpsTracker = new GPSTracker(this);
        if (myGpsTracker.canGetLocation())
        {
            double longitude = myGpsTracker.latitude;
            double latitude =  myGpsTracker.longitude;
        }
        else
        {
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            showSettingsAlert();
        }
 }

    /**
     * Function to show settings alert dialog
     * On pressing Settings button will lauch Settings Options
     */
    public void showSettingsAlert() 
    {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(SplashScreen.this);

        // Setting Dialog Title
        alertDialog.setTitle("GPS Settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not active. Do you want to open?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivityForResult(intent, CommonUtils.REQUEST_CODE_ACTION_LOCATION_SOURCE_SETTINGS);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                setLocationValues();

            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

      @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CommonUtils.REQUEST_CODE_ACTION_LOCATION_SOURCE_SETTINGS) {
            setLocationValues();
        }
    }

     private void setLocationValues() {
        myGpsTracker.getLocation();
        if (myGpsTracker.canGetLocation()) {
            double longitude = myGpsTracker.latitude;
            double latitude = myGpsTracker.longitude;
        } 
    }