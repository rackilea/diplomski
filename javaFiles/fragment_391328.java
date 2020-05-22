class syncX extends AsyncTask<String, String, String>
{
        ProgressDialog progress;
        Context mContext;

        public syncX(Context context){
          this.mContext= context;
        }

         public Context getContext(){
           return mContext;
         }


        @Override
        protected void onPreExecute()
        {
            super.onPreExecute();
            progress = new ProgressDialog(getContext());
            progress.setMessage("Setting BigBoard ");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progress.setIndeterminate(true);
            progress.show();
        }

        @Override
        protected String doInBackground(String... params)
        {
            return null;
        }

        @Override
        protected void onPostExecute(String file_url)
        {

        }    
}