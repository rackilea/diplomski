public class BackgroundWorker extends AsyncTask<String,Void,String> {
    ... // Member properties.
    // Define the listener interface.
    public interface OnTaskFinishedListener {
        void onTaskFinished(String result);
    }

    // Member property to reference listener.
    private OnTaskFinishedListener mOnTaskFinishedListener;

    // Setter for listener.
    public void setOnTaskFinishedListener(OnTaskFinishedListener listener) {
        mOnTaskFinishedListener = listener;
    }

    // Invoke the listener in the onPostExecute() method.
    @Override 
    protected void onPostExecute(String result) {
        // Only call it if it's set.
        if (mOnTaskFinishedListener != null) 
            mOnTaskFinishedListener.onTaskFinished(result);
    }
}