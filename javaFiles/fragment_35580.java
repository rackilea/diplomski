private class LongOperation extends AsyncTask<String, String, String> {
//                                                    ^^^^^^
        String input;

        @Override
        protected String doInBackground(String... params) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                    input = textInput.getText().toString();
                    publishProgress(input);
                   //^^^^^^^^^ pass the data to update UI
                } catch (InterruptedException e) {
                    Thread.interrupted();
                }
            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText(input); // txt.setText(result);
            // might want to change "executed" for the returned string passed
            // into onPostExecute() but that is upto you
        }

        @Override
        protected void onPreExecute() {}

        @Override
        protected void onProgressUpdate(String... values) {
            TextView txt = (TextView) findViewById(R.id.output);
            txt.setText(values[0]);
            // update the UI with Data received from publishprogress
        }
    }