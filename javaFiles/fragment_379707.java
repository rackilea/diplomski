if (!GetServer1.isEmpty() || !GetServer1.equals("")) {
     new MyTask().execute(GetServer1);
}

private class MyTask extends AsyncTask<String, Integer, String> {

        // Runs in UI before background thread is called
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Do something like display a progress bar

        }

        // This is run in a background thread
        @Override
        protected String doInBackground(String... params) {
            // get the string from params, which is an array
            int StatusCode = 0;
            try {
                String string  = params[0];

                url = new URL(string);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(3000);
                urlConnection.setReadTimeout(3000);
                urlConnection.setRequestMethod("GET");
                urlConnection.setInstanceFollowRedirects(false);
                urlConnection.connect();
                StatusCode = urlConnection.getResponseCode();

            } catch (Exception e) {
                //Toast.makeText(Act_Details.this, ""+e, Toast.LENGTH_SHORT).show();
            }

            return String.valueOf(StatusCode);
        }

        // This is called from background thread but runs in UI
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            // Do things like update the progress bar

        }

        // This runs in UI when background thread finishes
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            // Do things like hide the progress bar or change a TextView
            ResponseCode = result;

            switch (result) {
                case "200":
                    //Toast.makeText(Act_Details.this, result, Toast.LENGTH_SHORT).show();
                    ButtonS1.setEnabled(true);
                    ButtonS1.setText("ACTIVE");
                    break;
                case "403":
                    ButtonS1.setText("BLOCKED");
                    break;
                case "404":
                    ButtonS1.setText("DOWN");
                    break;
                default:
                    ButtonS1.setText("UNKNOWN / BROKEN");
                    break;
            }

        }
    }