public class ExampleTask extends AsyncTask<Void, Void, Bitmap> {

    private final WeakReference<ImageView> mImageViewReference;

    public ExampleTask(ImageView imageView) {
        mImageViewReference = new WeakReference<>(imageView);
    }

    @Override
    protected Bitmap doInBackground(Void... params) {
        ...
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);

        final ImageView imageView = mImageViewReference.get();
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
    }
}