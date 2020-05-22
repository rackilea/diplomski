int artColumnIndex = albumCursor.getColumnIndex(MediaStore.Audio.AlbumColumns.ALBUM_ART);

if(albumCursor!=null && albumCursor.moveToFirst()) {
    do {
        String artPath = albumCursor.getString(artColumnIndex);
    }  while (albumCursor.moveToNext());
}