class GetUserHttpTask extends AsyncTask<String/* in parameter for doInBackground */, Boolean /* in parameter for onProgressUpdate */, String /* Out parameter and in parameter for onPostExecute method*/> {
    @Override
    protected String doInBackground(String... params) {
        return "";
    }

    @Override
    protected void onPostExecute(String result) {
        // this doesn't run
    }

    @Override
    protected void onProgressUpdate(Boolean... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }
}