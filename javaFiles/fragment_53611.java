private class LoadActivity extends AsyncTask<String, Void, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        mainMethod();
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);

        takeScreenShot(1);
    }

    @Override
    protected String doInBackground(String... params) {
        return null;
    };
}