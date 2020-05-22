// gloabal variable of alert dialog.  
AlertDialog alert;


private void switchToGPSPreferences() {

    Log.i(CURRENT_ACTIVITY, "Inside Of switchToGPSPreferences()");
    AlertDialog.Builder builder = new AlertDialog.Builder(this);   
    builder.setTitle("GPS Settings");
    builder.alertDialogue.setCancelable(false);
    builder.alertDialogue.setMessage(ALER_DIALOGUE_MSG);


   builder.setNeutralButton("Settings",new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {

            dialog.dismiss();
            Intent gpsSettings = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            startActivityForResult(gpsSettings, GPS_SETTINGS_REQUEST_CODE);
        }
    });

    alert = builder.create();
    alert.show();

}// 
...
...
...
...
  @Override
      public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub  
          Toast.makeText(getApplicationContext(), USER_ENABLED_GPS, Toast.LENGTH_LONG).show();   
          Log.i(CURRENT_ACTIVITY, "GPS Enabled, onProviderEnabled()");  
                if (builder!= null) {   
                      // here ii want to dismiss/destroy the `alertdialoge`  
                       alert.dismiss();  
                    }

    }