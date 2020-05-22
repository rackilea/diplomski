public class DownloadFilesTask extends AsyncTask<void, void, void> {

     public DownloadFilesTask(){
          // Here you can pass data to the task
          // if you want to pass more than 1 type of data
     }

     protected void onPreExecute(){
         // this is executed on the UI Thread 
         // so you can modify elements inside the UI Thread
         // this is called after execute() is called and 
         // before doInBackground() is called
     }

     protected void doInBackground(Void... params) {
         //here you do all your network related stuff
         return null;
     }

     protected void onPostExecute(Void result) {
         // here you can work on the UI Thread
         // this is executed after the AsyncTask's execute() is finished
         // (after doInBackground() is done)
     }
 }