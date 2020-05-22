/*****************************************
 * AsyncTask Class to Parse and Display
 ******************************************/
class AsyncTaskClassName extends AsyncTask<Void,Void, Void>{
    ProgressDialog progressDialog = null;

    /* ***********************************
     * Pre-Execute Method 
     * ********************************** */
    @Override
    protected void onPreExecute() {
        progressDialog = util.getProgressDialog(ActivityClassName.this, "Please wait...", "Parsing List...    ");
           //ActivityClassName -> The Name of the Activity Class you want to show ProgressDialog
        // progressDialog.hide();
        progressDialog.show();

        /* Do your Pre-Execute Configuration */
    }

    /* ***********************************
     * Execute Method 
     * ********************************** */
    @Override
    protected Void doInBackground(Void... arg0) {
        /* Do yourxec Task ( Load from URL) and return value */
        return null;
    }

    /* ***********************************
     * Post-Execute Method 
     * ********************************** */
    @Override
    protected void onPostExecute(Void result) {
        progressDialog.dismiss();

                    /* Do your Post -Execute Tasks */
    }