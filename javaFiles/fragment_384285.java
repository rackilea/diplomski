private class LoadHydrantsToMapTask extends
        AsyncTask<Hydrant, Integer, List<MarkerOptions>> {

    private int loadHydrantsGoal = 0;

    public LoadHydrantsToMapTask(int loadHydrantsGoal) {
        this.loadHydrantsGoal = loadHydrantsGoal;
    }

    // Before running code in separate thread
    @Override
    protected void onPreExecute() {
        Device.lockOrientation((Activity)context);
        // Create a new progress dialog.
        progressDialog = new ProgressDialog(context);
        // Set the progress dialog to display a horizontal bar .
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setMessage(context
                .getString(R.string.adding_hydrants));
        // This dialog can't be canceled by pressing the back key.
        progressDialog.setCancelable(false);
        // This dialog isn't indeterminate.
        progressDialog.setIndeterminate(false);
        // The maximum number of progress items is 100.
        progressDialog.setMax(loadHydrantsGoal);
        // Set the current progress to zero.
        progressDialog.setProgress(0);
        // Display the progress dialog.
        progressDialog.show();

    }

    // The code to be executed in a background thread.
    @Override
    protected List<MarkerOptions> doInBackground(Hydrant... hydrants) {
        List<MarkerOptions> markers = new ArrayList<MarkerOptions>();

        for (Hydrant hydrant : hydrants) {

            final String hydrant_type = hydrant.getHydrantType();
            final String hydrant_icon_path = hydrant.getIconPath();
            double latitude = hydrant.getLatitude();
            double longitude = hydrant.getLongitude();

            final LatLng position = new LatLng(latitude, longitude);

            final String address = hydrant.getAddress();
            final String addressNumber = hydrant.getAddressNumber();
            final String addressremark = hydrant.getAddressRemark();
            final String remark = hydrant.getRemark();


            BitmapDescriptor icon = BitmapDescriptorFactory
                    .defaultMarker(BitmapDescriptorFactory.HUE_RED);

            if (!hydrant_icon_path.isEmpty()) {
                File iconfile = new File(hydrant_icon_path);
                if (iconfile.exists()) {
                    BitmapDescriptor loaded_icon = BitmapDescriptorFactory
                            .fromPath(hydrant_icon_path);
                    if (loaded_icon != null) {
                        icon = loaded_icon;
                    } else {
                        Log.e(TAG, "loaded_icon was null");
                    }
                } else {
                    Log.e(TAG, "iconfile did not exist: "
                            + hydrant_icon_path);
                }
            } else {
                Log.e(TAG, "iconpath was empty on hydrant type: "
                        + hydrant_type);
            }

            StringBuffer snippet = new StringBuffer();
            if (!address.isEmpty())
                snippet.append("\n" + address + " " + addressNumber);
            if (addressremark.isEmpty())
                snippet.append("\n" + addressremark);
            if (!remark.isEmpty())
                snippet.append("\n" + remark);

            markers.add(new MarkerOptions().position(position)
                    .title(hydrant_type).snippet(snippet.toString())
                    .icon(icon));

            publishProgress(markers.size());
        }
        return markers;
    }

    // Update the progress
    @Override
    protected void onProgressUpdate(Integer... values) {
        // set the current progress of the progress dialog
        progressDialog.setProgress(values[0]);
    }

    // after executing the code in the thread
    @Override
    protected void onPostExecute(List<MarkerOptions> markers) {

        GoogleMap map = GoogleMapsModule.getInstance().getMap();

        for (MarkerOptions marker : markers) {
            if (marker != null)
            map.addMarker(marker);
        }

        if (markers.size() == mHydrants.size()) {
            setAllHydrantAdded(true);
            setNearbyHydrantsAdded(true);
        } else {
            setNearbyHydrantsAdded(true);
        }
        Device.releaseOrientation((Activity) context);
    }
}