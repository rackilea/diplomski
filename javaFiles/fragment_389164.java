public void dedupe_playlist(Context context, long playlist_id) {
    Cursor cursor = plist.getPlaylistTracks(context, playlist_id);
    ArrayList<String> audio_ids = new ArrayList<>();

    // build up the array with audio_id's
    int i = 0;
    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
        String audio_id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists.Members.AUDIO_ID));
        audio_ids.add(audio_id);

    }

    i = 0;
    int duplicates = i;
    boolean success = false;
    for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {
        String audio_id = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Playlists.Members.AUDIO_ID));
        duplicates = audio_ids.lastIndexOf(audio_id);
        if (duplicates > i) {
            success = true;
            cursor.moveToPosition(duplicates);
            int _id = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Playlists.Members._ID));
            removePlaylistTrack(context, playlist_id, _id);
            audio_ids.set(duplicates, null);
            cursor.moveToPosition(i - 1);        // move back to test again
        } else {
            i++;
        }
    }

    if (success) {
        renumber_playorder(context, playlist_id);
    }
    try {
        cursor.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

}


     public void removePlaylistTrack(Context context, long selectedplaylist,
                                int _id) {

    ContentResolver resolver = context.getContentResolver();
    Uri newuri = MediaStore.Audio.Playlists.Members.getContentUri(
            "external", selectedplaylist);
    try {
        resolver.delete(newuri, MediaStore.Audio.Playlists.Members._ID + " = " + _id, null);
    } catch (Exception e) {
        e.printStackTrace();
    }
}