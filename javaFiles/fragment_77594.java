class ExampleTask extends AsyncTask<String, String, String> {

    // Your onPreExecute method.

    @Override
    protected String doInBackground(String... params) {
        // Your code.
        if (condition_is_true) {
            this.publishProgress("Show the dialog");
        }
        return "Result";
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        connectionProgressDialog.dismiss();
        downloadSpinnerProgressDialog.show();
    }
}