private class MyTask extends AsyncTask<String, Integer, String> {
   // This happens on the background thread, do not attempt to access anything on the UI thread
   @Override
   protected String doInBackground(String... urls) {
      if( urls == null || urls.length < 1 ) {
         return null;
      }
      HttpClient client = new DefaultHttpClient();
      HttpGet request = new HttpGet(urls[0]);
      HttpResponse response = client.execute(request);

      return EntityUtils.toString(response.getEntity());
   }

   // This happens on the UI thread. Do any visual updates here
   @Override
   protected void onPostExecute(String result) {
      if( result != null ) {
          // Do something with it
      }
   }
}