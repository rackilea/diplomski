new AsyncTask<String, Void, String>() {
    @Override protected String doInBackground(String... params) {
        // we do this part in the background on another thread
        return petrolPriceString(params[0]);
    }
    @Override protected void onPostExecute(String result) {
        // result is the value returned from our call to petrolPriceString
        // anything we put in here is done on the main/UI thread
    }
}.execute(urlString);