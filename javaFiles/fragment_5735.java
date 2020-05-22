private class GetLocationTask extends AsyncTask <Void, Void, Location> {
  private Future<Location> future;
  private ExecutorService executor = new ScheduledThreadPoolExecutor(5);
  private boolean cancelTriggered = false;

  protected void onPreExecute() {
    Log.d(TAG, "Starting location get...");
  }

  public Location doInBackground(Void... arg) {
    CurrentLocation currLoc = new CurrentLocation(getApplicationContext());
    future = executor.submit(currLoc);
    long LOCATION_TIMEOUT = 20000; // ms = 20 sec
    try {
      // return future.get(Constants.LOCATION_TIMEOUT, TimeUnit.MILLISECONDS);
      return future.get(LOCATION_TIMEOUT, TimeUnit.MILLISECONDS);
    } catch (Exception e) {
      Log.w(TAG, "Location get timed out");
      future.cancel(true);
      return null;
    }
  }

  public boolean killTask() {
    cancelTriggered = true;
    boolean futureCancelRes = future.cancel(true);
    this.cancel(true);
    Log.d(TAG, "Result of cancelling task: " +futureCancelRes);
    return futureCancelRes;
  }


  protected void onPostExecute(Location res) {
    if (cancelTriggered) {
      Log.d(TAG, "User initiated cancel - this is okay");
      cancelTriggered = false;
    } else if (res == null) {
      Log.d(TAG, "Could not get a location result");
    } else {
      double lat = res.getLatitude();
      double lon = res.getLongitude();
      Log.d(TAG, "Latitude: " +lat);
      Log.d(TAG, "Longitude: " +lon);
    }
  }
}