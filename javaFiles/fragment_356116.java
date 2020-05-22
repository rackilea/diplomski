private class LongOperation extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... params) {
        //Send your HTTP REQUESTS HERE.
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        //UPDATE YOUR UI HERE AFTER RETRIEVING DATA FROM HTTP REQUEST
    }

    @Override
    protected void onPreExecute() {}

    @Override
    protected void onProgressUpdate(Void... values) {}
}
}