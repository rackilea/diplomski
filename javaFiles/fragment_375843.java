public class ExampleActivty extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ...

        final ImageView imageView = (ImageView) findViewById(R.id.image);
        new ExampleTask(imageView).execute();
    }

    public class ExampleTask extends AsyncTask<Void, Void, Bitmap> {

        private final WeakReference<ImageView> mListenerReference;

        public ExampleTask(ImageView imageView) {
            mListenerReference = new WeakReference<>(imageView);
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            ...
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            final ImageView imageView = mListenerReference.get();
            if (imageView != null) {
                imageView.setImageAlpha(bitmap);
            }
        }
    }
}