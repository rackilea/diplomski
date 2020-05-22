@Override
protected void onPostExecute(Bitmap bitmap) {
    if (mHolder.position == mPosition) {
        mHolder.thumbnail.setImageBitmap(bitmap);
    }
}