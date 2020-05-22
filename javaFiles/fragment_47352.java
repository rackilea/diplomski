private static final class LoadImageFromUrl extends AsyncTask<Void, Void, Bitmap> {

    private WeakReference<Callbacks> mCallbacks;

    public LoadImageFromUrl(String url, Callbacks callbacks) {
        mCallbacks = new WeakReference<>(callbacks);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Callbacks cb = mCallbacks.get();
        if (cb != null) cb.successfully(bitmap);
    }
}