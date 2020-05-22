// retrieve more metadata, duration etc.
ContentValues contentValues = new ContentValues();
contentValues.put(MediaStore.Audio.AudioColumns.DATA, "/mnt/sdcard/Music/example.opus");
contentValues.put(MediaStore.Audio.AudioColumns.TITLE, "Example track");
contentValues.put(MediaStore.Audio.AudioColumns.DISPLAY_NAME, "example");
// more columns should be filled from here
Uri uri = getContentResolver().insert(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, contentValues);
Log.d(TAG, uri.toString());