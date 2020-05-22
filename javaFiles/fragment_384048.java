public class LoadURL extends AsyncTask<String, Process, String> {

    private AsyncTaskCompleteListener<String> callback;

    public LoadURL(AsyncTaskCompleteListener<String> cb) {
        this.callback = cb;
     }

    protected void onPreExecute() {}

    protected String doInBackground(String... arg0) {
         // do something
        return content;
    }

    protected void onPostExecute(String content) {
        if (callback != null)
            callback.onTaskComplete(content,number);
    }
}