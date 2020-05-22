private class BackgroundTask extends AsyncTask<Integer, Integer, void> {
    private ProgressDialog dialog;

    @Override
    protected void onPreExecute() {
        dialog = ProgressDialog.show(SettingsActivity.this, "", "Doing stuff...", true);
    }

    @Override
    protected void doInBackground(Integer... params) {
        sleep(params[0]);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        dialog.dismiss();
    }
 }