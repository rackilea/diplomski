private class BigComputationTask extends AsyncTask<Void, Void, Void> {

  @Override
  protected void onPreExecute() {
    // Runs on UI thread
    Log.d(TAG, "About to start...");
  }

  @Override
  protected Void doInBackground(Void... params) {
    // Runs on the background thread
    doBigComputation();
  }

  @Override
  protected void onPostExecute(Void res) {
    // Runs on the UI thread
    Log.d(TAG, "Big computation finished");
    startTheApp();
  }

}