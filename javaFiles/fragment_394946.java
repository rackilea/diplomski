private class AsyncJsonTask extends AsyncTask<Param, LocationData, Void>
{
    private List<LocationData> locationList = new ArrayList<LocationData>();
    // ...
    protected void doInBackground(Param) {
        // ...
        for (int i = 0; i < jsonArr.length(); i++) {
            // Do your stuff with JSon Objects
            // ...
            // Instanciate a new LocationData and pass it as progress:
            LocationData data = new LocationData(latitude, longitude, name);
            locationList.add(data);
            publishProgress(data);
        }
    }

    protected void onProgressUpdate(LocationData data) {
        // Add Marker on Map using data. This is called by
        // publishProgress(LocationData) on the UI Thread.
        mMap.addMarker(/* marker */);
    }

    protected void onPostExecute() {
        // Assign outer class member field the value of the builded list
        // for future reference.
        mLocationList = locationList;
    }
}