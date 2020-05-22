private class RestTask extends AsyncTask<Object, Object, String> {
    protected String doInBackground(Object... args) {
        // this happend on background thread
        return downloadData();
    }

    protected void onPreExecute() {
        // this happend on UI thread
        showSpinner();
    }

    protected void onPostExecute(String result) {
        // this happend on UI thread
        hideSpinner();
        doSomethingWithDownloadResult(result);
    }
}