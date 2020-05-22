class LoadImage extends AsyncTask<String, Void, Bitmap> {

private final WeakReference<ImageView> imageViewReference;

public LoadImage(ImageView imageView) {
    imageViewReference = new WeakReference<ImageView>(imageView);
}

@Override
protected Bitmap doInBackground(String... params) {
    try {
        return downloadBitmap(params[0]);
    } catch (Exception e) {
       // log error
    }
    return null;
}

@Override
protected void onPostExecute(Bitmap bitmap) {
    if (isCancelled()) {
        bitmap = null;
    }

    if (imageViewReference != null) {
        ImageView imageView = imageViewReference.get();
        if (imageView != null) {
            if (bitmap != null) {
                imageView.setImageBitmap(bitmap);
            } else {
                Drawable placeholder = imageView.getContext().getResources().getDrawable(R.drawable.ic_launcher);
                imageView.setImageDrawable(placeholder);
            }
        }
    }
}

private Bitmap downloadBitmap(String url) {
    HttpURLConnection urlConnection = null;
    try {
        URL uri = new URL(url);
        urlConnection = (HttpURLConnection) uri.openConnection();
        int statusCode = urlConnection.getResponseCode();
        if (statusCode != HttpStatus.SC_OK) {
            return null;
        }

        InputStream inputStream = urlConnection.getInputStream();
        if (inputStream != null) {
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        }
    } catch (Exception e) {
        urlConnection.disconnect();
        Log.w("ImageDownloader", "Error downloading image from " + url);
    } finally {
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
    }
    return null;
}