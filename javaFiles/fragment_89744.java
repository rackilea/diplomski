class MyTask extends AsyncTask<Void, Void, Void> {
 ProgressDialog pd;
    @Override
    protected void onPreExecute() {
      super.onPreExecute();
       pd = new ProgressDialog(MainActivity.this);
       pd.setMessage("loading");
       pd.show();
    }

    @Override
    protected Void doInBackground(Void... params) {
      // Do your request
    }

    @Override
    protected void onPostExecute(Void result) {
      super.onPostExecute(result);
      if (pd != null)
      {
         pd.dismiss();
      }
    }
  }