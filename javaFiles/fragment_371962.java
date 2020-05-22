private class SeriesSearchTask extends AsyncTask<String, Void, String> {
    MyActivity mActivity;

    public SeriesSearchTask(final MyActivity _activity){
        mActivity = _activity;
    }

    @Override
    protected String doInBackground(String... urls) {
        // params comes from the execute() call: params[0] is the url.
        try {
            ALTS = DB.searchSeriesInTVDB(urls[0], Language.ENGLISH);
            return Integer.toString(ALTS.size());
        } catch (TVDBOutboundConnectionException e) {
            return "Unable to retrieve web page. URL may be invalid.";
        }
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {

        //updating the UI here
        if(mActivity != null){
            mActivity.runOnUiThread(new Runnable(){
                public void run(){
                    mActivity.updateUi();
                }
            }
        }

    }
}