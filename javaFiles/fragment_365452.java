public class MyTask extends AsyncTask < ... > {
    // Maintain a ref to callback
    OnCallCompleteCallBack callback;

    MyTask(OnCallCompleteCallBack callback) {
        this.callback = callback;
    }

    ...

    @Override
    protected void onPostExecute(Void aVoid) {
        if (callback != null) {
            callback.onCallComplete(listSize);
        }
    }
}