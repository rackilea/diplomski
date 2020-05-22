public class ExampleTask extends AsyncTask<Void, Void, Bitmap> {

    public interface Listener {
        void onResult(Bitmap image);
    }

    private final WeakReference<Listener> mListenerReference;

    public ExampleTask(Listener listener) {
        mListenerReference = new WeakReference<>(listener);
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        ...
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        final Listener listener = mListenerReference.get();
        if (listener != null) {
            listener.onResult(bitmap);
        }
    }
}