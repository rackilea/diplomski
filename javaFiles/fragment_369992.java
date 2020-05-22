private class ClassName extends AsyncTask<Void, Void, Void>
{
     ProgressDialog pd = new ProgressDialog(SignUp.this);

     @Override
     protected void onPreExecute()
     {
            pd.setMessage("Please wait..");
            pd.setCancelable(false);
            pd.show();
   }

   @Override
   protected Void doInBackground(Void... arg0)
   {
    ..................................
    //your code for json calling -- Server call 1
    ..................................
    //use runOnUi thread to update ui
    ..................................

     runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // WORK on UI thread here
            }
        });

    ..................................
    //your code for json calling -- Server call 2
    ..................................
    //use runOnUi thread to update ui
    ..................................

    runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // WORK on UI thread here
            }
        });



       return null;
    }

    @Override
    protected void onPostExecute(Void result)
    {
      super.onPostExecute(result);

      if(pd.isShowing())
         pd.dismiss();
    }