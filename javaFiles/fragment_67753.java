{
        int genreId = 2; // << Set Your Genre ID Here
        Uri uri = MediaStore.Audio.Albums.getContentUri("external");
        Log.i("XXX", "uri = " + uri.toString());
        Cursor cursor = null;
        try {

            String selection = "album_info._id IN "
                    + "(SELECT (audio_meta.album_id) album_id FROM audio_meta, audio_genres_map "
                    + "WHERE audio_genres_map.audio_id=audio_meta._id AND audio_genres_map.genre_id=?)";
            String[] selectionArgs = new String[] { String.valueOf(genreId) };
            String[] proj = { AlbumColumns.ALBUM };
            cursor = getContentResolver().query(uri, proj, selection,
                    selectionArgs, null);
            if (null != cursor) {
                Log.i("XXX", "cursor rows count = " + cursor.getCount());
                while (cursor.moveToNext()) {
                    Log.i("XXX", "  Album: " + cursor.getString(0));
                }
                cursor.close();
                Log.i("XXX", "cursor closed");
            }
        } catch (Exception ex) {
            Log.e("XXX", "Error Querying Database");
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }