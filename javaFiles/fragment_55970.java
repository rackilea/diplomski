private class TranslateTask extends AsyncTask<String, Void, String> {
     protected void onProgressUpdate() {

     }

     protected void onPostExecute(String... result) {
         String translated = result[0];
     }

    @Override
    protected String doInBackground(String... params) {
        String toTranslate = params[0];
        String language = params[1];
                // translate here and return the result
                return translated;
            }
 }