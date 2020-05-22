protected class ImageLoader extends AsyncTask<String, Void, Bitmap> {
        protected Bitmap doInBackground(String... urls) {
            Bitmap bitmap = null;
            String originalUrl = urls[0];
            String url = urls[0].replaceFirst("/500.", "/1000.");
            try {
                InputStream inputStream = new URL(url).openStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                try {
                    InputStream inputStream = new URL(originalUrl).openStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (Exception ignored) {
                }
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap bitmap) {
            //do whatever you want with the result.
            if(bitmap!=null)
            image.setImageBitmap(bitmap);
        }
    }