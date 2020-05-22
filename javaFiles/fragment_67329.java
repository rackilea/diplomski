private class MyBackgroundTask extends AsyncTask<String, Void, Boolean> {

    @Override
    protected void onPreExecute() {
        //initialize views like progress dialog.
    }

    @Override
    protected Boolean doInBackground(String... params) {
        //Add code which you want to run in background.
        //In your case, code to load sound pools
    }

    @Override
    public void onPostExecute(Boolean success) {
        //update UI with the result
    }
}