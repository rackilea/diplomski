private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {
 protected Void doInBackground(Param[]...) {
     createConnection();
 }

 protected void onProgressUpdate() {
     setProgressPercent(progress[0]);
 }

 protected void onPostExecute() {


 }