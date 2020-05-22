public class SensorTask extends AsyncTask<Void, Void, Void> {

    protected void onPreExecute() {
        // runs on the UI thread
        // TODO set up your UI for data acquisition
    }

    protected Void doInBackground(Void... params) {

        // TODO initialize sensor for acquisition

        while (! isCancelled()) {

            synchronized (nativeData) {
                nativeData = getDatafromsensor(); // Data from native.
            }
            publishProgress(null);  // this invokes onProgressUpdate on UI thread
            Thread.sleep(DELAY_TIME);  // if you need to
        }

        // TODO sensor cleanup
    }

    protected void onProgressUpdate(Void... values) {
        // runs on the UI thread
        synchronized (nativeData) {
            // TODO update your UI with the sensor data
        }
    }

    protected void onCancelled(Void result) {
        // runs on the UI thread
        // TODO update UI for acquisition complete
    }

}