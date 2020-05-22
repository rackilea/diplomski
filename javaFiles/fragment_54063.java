new AsyncTask<Void, Void, Void>() {

        @Override
        protected void onPreExecute()
        {
            Log.d(TAG, "onPreExecute()");
        }

        @Override
        protected Void doInBackground(Void... params)
        {
            Log.d(TAG, "doInBackground() -- Here is the download");
            m.send();
            return null;
        }

        @Override
        protected void onPostExecute(Void res)
        {
            Log.d(TAG, "onPostExecute()");
        }
    }.execute();