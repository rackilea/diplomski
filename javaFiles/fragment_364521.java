private class GetBitmapFromURLAsync extends AsyncTask<String, Void, Bitmap>   {
    @Override
    protected Bitmap doInBackground(String... params) {
        return getBitmapFromURL(params[0]);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
    }
}