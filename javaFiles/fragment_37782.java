public static long getTrackIdByPath(Context context, String pathToFile){
long id = - 1;
String[] projection = {MediaStore.Audio.Media._ID,
                       MediaStore.Audio.Media.DATA};
String selection = MediaStore.Audio.Media.DATA + " like ?";
Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
        projection, selection,
        new String[] {pathToFile}, null);
cursor.moveToFirst();
if(cursor.getCount() > 0)
    id = cursor.getLong(0);
cursor.close();
return id;