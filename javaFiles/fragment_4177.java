private class DoStuffTask extends AsyncTask {

   @Override
   protected void doInBackground(Object... args) {
       // Do stuff
       onProgressUpdate(x);
       // Do more stuff
   }

   @Override
   protected void onProgressUpdate(Object... args) {
       // Update your UI here
   }
}