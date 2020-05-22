public String getalbum_id(Cursor pcursor) {
    int album_col = pcursor
            .getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID);
    String album_id = pcursor.getString(album_col);

    if (album_id.length() > 0) {
        return album_id;
    } else {
        return "";
    }
}

public String getAlbumIdfromPath(Context context, String datapath) {
    ContentResolver cr = context.getContentResolver();
    final String _id = MediaStore.Audio.Media._ID;
    final String path = MediaStore.Audio.Media.DATA;
    final String album_id = MediaStore.Audio.Media.ALBUM_ID;
    final String[] columns = {_id, album_id};
    final String[] trackpath = {"%" + datapath + "%"};
    String where = path + " LIKE ?";
    String stralbum_id = null;
    Cursor crs = cr.query(uri, columns, where, trackpath, null);
    if (crs != null && crs.moveToFirst()) {
        stralbum_id = crs.getString(crs.getColumnIndexOrThrow(album_id));
        crs.close();
    }
    return stralbum_id;
}