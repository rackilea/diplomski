ContentResolver resolver = getContentResolver();
long trackId = getTrackIdByPath(context, pathToFile);
    Uri uri = MediaStore.Audio.Playlists.Members.getContentUri("external", playListId);
    Cursor cursor = resolver.query(uri, new String[] {"count(*)"}, null, null, null);
    cursor.moveToFirst();
    int last = cursor.getInt(0);
    cursor.close();
    ContentValues value = new ContentValues();
        value.put(MediaStore.Audio.Playlists.Members.PLAY_ORDER, ++last);
        value.put(MediaStore.Audio.Playlists.Members.AUDIO_ID, trackId);

    resolver.insert(uri, value);