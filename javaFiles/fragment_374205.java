public class TestActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MyAsyncTask(getApplicationContext(), "some url").execute();
    }

    private static class MyAsyncTask extends AsyncTask<Void, Void, Bitmap> {

        private Context context;
        private String url;

        MyAsyncTask(Context context, String url) {
            this.context = context;
            this.url = url;
        }

        @Override
        protected Bitmap doInBackground(Void... params) {
            try {
                return Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .into(256, 256)
                        .get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);

            if (null != bitmap) {
                // show notification using bitmap
            } else {
                // couldn't fetch the bitmap
            }
        }
    }
}