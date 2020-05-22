private class LongRunningTask extends AsyncTask<Void, Boolean, Boolean> {

    private ProgressDialog progress;

    protected void onPreExecute() {
        progress = ProgressDialog.show(yourContext, "Title", "Text");
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        return true;
    }

    protected void onPostExecute(Boolean result) {
        if(result) {
           progress.dismiss();
        }
    }

}