private class GetStringFromNetwork extends AsyncTask<String, Integer, String> {
     protected Long doInBackground(String... strings) {
         // here you can use those strings to do some expensive
         // computation or long task, like fetching data from the network.
         // during the task, you can use publishProgress(<Integer value>)
         // to update the method below on how far done your task is.
         return "whatever you got back from the server";
     }

     protected void onProgressUpdate(Integer... progress) {
         // use this to update the UI and tell the user how far done you are
     }

     protected void onPostExecute(String result) {
         // use this to update the UI with your result (the return from doInBackground)
     }
 }