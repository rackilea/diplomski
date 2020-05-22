public ArrayList<Bitmap> getChamp_splash() {
    ...
    ...
    ArrayList<Bitmap> bitmaps = new ArrayList<Bitmap>();
    if (c != null) {
            while (c.moveToNext()) {
                byte[] blob = c.getBlob(c.getColumnIndex("champ_splash"));
                bitmap = BitmapFactory.decodeByteArray(blob, 0, blob.length);
                bitmaps.add(bitmap);
            }
    }
    ...
    ...
    return bitmaps;
}