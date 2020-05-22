Double latToPass;
    Double longToPass;


protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

new AsyncAction().execute(null, null, null);

}





    private class AsyncAction extends AsyncTask<String, Void, String> {
            public boolean status = false;
            private ProgressDialog pd;

            @Override
            protected String doInBackground(String... arg0) {
                // TODO Auto-generated method stub
                try {
                    locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);    

            locationListener = new GPSLocationListener();

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);


                    status = true;

                } catch (Exception e) {
                    // TODO: handle exception
                }

                return null;
            }

            @Override
            protected void onPostExecute(String result) {

                pd.dismiss();

            Intent changesStart = new Intent("com.example.flybaseapp.PassLatLong");
                    changesStart.putExtra("passedLat", latToPass);
                    changesStart.putExtra("passedLong", longToPass);
                    startActivity(changesStart);


                }
            }

            protected void onPreExecute() {
                // TODO Auto-generated method stub
                super.onPreExecute();
                pd = new ProgressDialog(MainActivity.this);
                pd.setMessage("loading...");
                pd.setIndeterminate(true);
                pd.setCancelable(false);
                pd.show();
            }

        }


      private class GPSLocationListener implements LocationListener 
        {
            @Override
            public void onLocationChanged(Location location) {
                if (location != null) {



                    latToPass = location.getLatitude();
                    longToPass = location.getLongitude();

                    locationManager.removeUpdates(locationListener);
                    //locationManager = null;


                }
            }