// Method to return a bitmap from an images URL
private Bitmap getImageBitmap(String url) {
Bitmap bm = null;
try {

    // See what we are getting
    Log.i(TAG, "" + url);

    URL aURL = new URL(url);
    URLConnection conn = aURL.openConnection();
    conn.connect();

    InputStream is = conn.getInputStream();
    BufferedInputStream bis = new BufferedInputStream(is);
    bm = BitmapFactory.decodeStream(bis);

    bis.close();
    is.close();
} catch (IOException e) {
    Log.e(TAG, "Error getting bitmap", e);
}
return bm;