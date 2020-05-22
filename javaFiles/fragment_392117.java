public class WaitAsyncTask extends AsyncTask<String, Void, String> {

    private WeakReference<MainActivity> activityRef;

    public WaitAsyncTask(MainActivity activity){
        activityRef = new WeakReference<MainActivity>(activity);
    }

     @Override
     protected void onPreExecute() {
        super.onPreExecute();
        // show dialog
    }
    @Override
    protected String doInBackground(String... params) {
        // do you work in background
        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        // hide dialog
        if(activityRef.get() != null){
            // call load completed method in activity
            activityRef.get().loadCompleted(data);
        }
    }
} // WaitAsyncTask