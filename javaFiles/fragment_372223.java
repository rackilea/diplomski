private TextView tv;

@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_competetion);

    tv = (TextView) findViewById(R.id.competetion_text);
    JsonCollector jc = new JsonCollector();

    // Create and execute a new AsyncTask, the TextView will
    // be updated asynchronously when the task has finished.
    updateTextView();
}

private void updateTextView() {
    new AsyncTask<Void, Void, String>() {

        @Override
        /* Runs on a separate thread */
        protected String doInBackground(Void... params) {
            String result = null;
            BufferedReader reader = null;
            try {
                URL url = new URL("http://api.heroesofnewerth.com/player_statistics/ranked/nickname/Hieratic/?token=0CZGH8ZI7UR8J2GN");
                reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                for (String line; (line = reader.readLine()) != null;) {
                    System.out.println(line);
                    result = line;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // Ignore
                    }
                }
            }

            return result;  
        }

        @Override
        /* Runs on the UI/Main thread when doInBackground()
         * has finished */
        protected void onPostExecute(String result) {
            if(result != null) {
                // Update the TextView only if we got a result
                // from the HTTP request
                tv.setText(result);
            }
        }

    }.execute();
}