class myAsyncTask extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected Boolean doInBackground(String... url) {
        // This will receive the String you passed into it and return a boolean to onPostExecute()
        // Put all your CPU intensive stuff here

        // publishProgress can be used update the UI thread
        Integer progress = 1;
        publishProgress(progress);

        return true;
    }

    @Override
    protected void onProgressUpdate(Integer... doInBackgroundResult) {
        super.onProgressUpdate(doInBackgroundResult);
        // Anything done here can update the UI but will block
    }

    @Override
    protected void onPostExecute(Boolean doInBackgroundResult) {
        super.onPostExecute(doInBackgroundResult);
        // Runs after doInBackground finishes
        // Anything done here will block the UI
    }
}