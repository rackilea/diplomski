// Observer listener interface design
interface ResultListener{
    // You can overload this method with data type you want to return
    public void onResultReceived();

    // Use them in a proper way for sending error message back to your program
    public void onTaskCancelled();
    public void onError();

}
 // This will be your new method signature
 public String startTask(ResultListener listener){
     // Call it liske this, passing listener reference
     new UploaderTaskStandard().execute(listener);
 }

 // This is your AsyncTask model
 public class UploaderTaskStandard extends AsyncTask<ResultListener, Void, Void> {

     ResultListener listener;

        @Override
        protected Void doInBackground(ResultListener... maps) {
            this.listener = maps[0];
            uploadData();
            return null;
        }

        protected void onPostExecute(Void v) {
            /*Do something after the task is complete*/
            simpleDialog.dismiss();
            // Notify back to calling program
            listener.onResultReceived();
        }

 }