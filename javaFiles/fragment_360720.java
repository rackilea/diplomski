public class AsyncCallWS extends AsyncTask<String, Void, List<String>> {
    @NonNull
    private OnTaskCompleteCallback callback;

    public AsyncCallWS(@NonNull OnTaskCompleteCallback callback) {
        this.callback = callback;
    }

    @Override
    protected List<String> doInBackground(String... params) {
        try {
            //fetch data from web service
            List<String> result = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                //here you can add all needed values which will be used in spinner
                result.add("Item " + i);
            }
            return result;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        callback.dataReady(strings);
    }

    public interface OnTaskCompleteCallback {
        void dataReady(@NonNull List<String> data);
    }
}