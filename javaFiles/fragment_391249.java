interface Callback {
    void onValueReceived(String value);
    void onFailure();
}

class MyAwesomeAsyncTask extends AsyncTask<Void, Void, String> {

    private Callback callback;

    MyAwesomeAsyncTask(final Callback callback) {
        this.callback = callback;
    }

    @Override
    protected String doInBackground(final Void... voids) {
        String s = amazingCallToBackend();
        return s;
    }

    @Override
    protected void onPostExecute(final String s) {
        callback.onValueReceived(s);
    }
}