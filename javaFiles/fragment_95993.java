public class SensorTask extends AsyncTask<Void, List<Double>, Void> {

    protected void onPreExecute() {
        // runs on the UI thread
        // TODO set up your UI for data acquisition
    }

    protected Void doInBackground(Void... params) {

        // TODO initialize sensor for acquisition

        while (! isCancelled()) {

            nativeData = getDatafromsensor(); //Data from native.
            List<Double> sensorData = new ArrayList<Double>();

            for (int i = 0; i < nativeData.length; i++) {
                sensorData.add(new Double(nativeData[i]);
            }
            publishProgress(sensorData);  // this invokes onProgressUpdate on UI thread
            Thread.sleep(DELAY_TIME);  // if you need to
        }

        // TODO sensor cleanup
    }

    protected void onProgressUpdate(List<Double>... values) {
        // runs on the UI thread
        // TODO update your UI with the sensor data
    }

    protected void onCancelled(Void result) {
        // runs on the UI thread
        // TODO update UI for acquisition complete
    }

}