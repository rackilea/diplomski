public class Api extends AsyncTask<String, Void, String> {
    public final Callback<String> callback;

    public Api(Callback callback) {
        this.callback = callback;
    }

    // other methods ...

    @Override
    public void onPostExecute(String response) {
        callback.execute(response);
    }
}