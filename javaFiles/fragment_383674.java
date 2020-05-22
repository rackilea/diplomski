new AsyncTask<String, Void, String>() {
    IOException exception = null;
    @Override protected String doInBackground(String... params) {
        try {
            return petrolPriceString(params[0]);
        } catch (IOException e) {
            exception = e;
            return null;
        }
    }
    @Override protected void onPostExecute(String result) {
        if (exception != null) {
            // handle our exception
        } else {
            // handle our result
        }
    }
}.execute(urlString);