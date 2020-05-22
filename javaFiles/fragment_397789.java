private class LongOperation extends AsyncTask<Void, Void, String> {

        private String mUrl;
        private JSONObject mData;

        public LongOperation(String url, JSONObject data) {
           mUrl = url;
           mData = data;
        }

        @Override
        protected String doInBackground(Void... params) {
            return request(mUrl, mData);
        }

        @Override
        protected void onPostExecute(String response) {
           Toast.makeText(getApplicationContext(),response,
              Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(Void... values) {}
}