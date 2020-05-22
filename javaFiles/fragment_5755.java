public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {

        private final WeakReference<ImageView> imageViewReference;

        public ImageDownloader(ImageView imageView) {
            imageViewReference = new WeakReference<ImageView>(imageView);
        }

        protected void onPreExecute() {
            //Setup is done here
        }

        @Override
        protected Bitmap doInBackground(String... params) {
            //this where i get the image using HttpURLConnection
        }

        protected void onProgressUpdate(Integer... params) {
            //Update a progress bar here, or ignore it, it's up to you
        }

        protected void onPostExecute(Bitmap bitmap) {

            if (imageViewReference != null && bitmap != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
        }
    }