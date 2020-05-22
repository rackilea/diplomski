public class Comm extends AsyncTask<String, Void, String> {
    private TaskCompleteListener taskCompleteListener = null;

    public Comm(TaskCompleteListener taskCompleteListener){
        this.taskCompleteListener = taskCompleteListener;
    }

    protected String doInBackground(String... params) {
        //Network operations 
        return responseFromServer;
    }

   protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //Here should come the code which should update the view
        taskCompleteListener.onTaskComplete(s);
    }
}