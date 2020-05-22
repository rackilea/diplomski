@Override
    protected void onPreExecute()
    {
        super.onPreExecute();
        pDialog = new ProgressDialog(YOUR_ACTIVITY_CLASS_NAME.this);
        pDialog.setMessage("Please Wait");
        pDialog.setIndeterminate(false);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected void onPostExecute(String str)
    {
        // Dismiss the dialog once finished
        pDialog.dismiss();  
    }