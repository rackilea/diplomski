protected Bitmap doInBackground(String... urls) {
    List<Bitmap> bitmaps = new ArrayList<Bitmap>;
    for (String url : urls) {
        bitmaps.add(downloadImage(url));
    }
    return bitmaps;     
}

protected void onPostExecute(List<Bitmap> result) {
    //...
}