private class GetExampleDetails extends AsyncTask<String, Void, Void> {

    private ProgressDialog dialog = new ProgressDialog(ExpensesListView.this);
    String strMsg = null;

    protected void onPreExecute() {
        this.dialog.setMessage("Loading.....");
        this.dialog.setCanceledOnTouchOutside(false);
        this.dialog.show();

    }

    // automatically done on worker thread (separate from UI thread)
    protected Void doInBackground(final String... a) {

        try
        {

            //Write your code. which one do backround
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return null;
    }

    // can use UI thread here
    protected void onPostExecute(final Void unused) {


        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
            this.dialog = null;
        }


    }

}//Endtask