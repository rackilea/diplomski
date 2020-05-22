private class MyAsyncTask extends AsyncTask<Object , Object , Object > {
     protected Object doInBackground(Object... urls) {
         // do some thing in background
         return result;
     }
@Override
    protected void onPreExecute() {

    // this will execute on main thread before Method doInBackground()

        super.onPreExecute();
    }

     protected void onPostExecute(Object result) {
// this will execute on main thread after Method doInBackground()

     }
 }