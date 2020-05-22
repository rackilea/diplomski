private class Download extends AsyncTask<String, Void, String> {
    ProgressDialog pDialog;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("Hi", "Download Commencing");

        pDialog = new ProgressDialog(MainActivity.this);
        pDialog.setMessage("Downloading Database...");


        String message= "Executing Process";

        SpannableString ss2 =  new SpannableString(message);
        ss2.setSpan(new RelativeSizeSpan(2f), 0, ss2.length(), 0);  
        ss2.setSpan(new ForegroundColorSpan(Color.BLACK), 0, ss2.length(), 0); 

        pDialog.setMessage(ss2);

        pDialog.setCancelable(false);
        pDialog.show();
    }

    @Override
    protected String doInBackground(String... params) {

        //INSERT YOUR FUNCTION CALL HERE

        return "Executed!";

    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("Hi", "Done Downloading.");
        pDialog.dismiss();

    }
}