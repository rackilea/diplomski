class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
    ImageView bitImage;

    public DownloadImageTask(ImageView bitImage) {
        this.bitImage = bitImage;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mBmp = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mBmp = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mBmp;
    }

    protected void onPostExecute(Bitmap result) {
        bitImage.setImageBitmap(result);
    }
}