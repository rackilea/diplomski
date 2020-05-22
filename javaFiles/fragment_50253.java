// Params are input and output files, progress in Long size of 
// data transferred, Result is Boolean success.
public class MyTask extends AsyncTask<File,Long,Boolean> {
   ProgressDialog progress; 

  @Override
  protected void onPreExecute() {
    progress = ProgressDialog.show(ctx,"","Loading...",true);
  }

  @Override
  protected Boolean doInBackground(File... files) {
    copyFiles(files[0],files[1]);
    return true;
  }

  @Override
  protected void onPostExecute(Boolean success) {
    progress.dismiss();
    // Show dialog with result
  }

  @Override
  protected void onProgressUpdate(Long... values) {
    progress.setMessage("Transferred " + values[0] + " bytes");
  }
}