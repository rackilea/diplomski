public static File getAppFileDir(Context context) {
    File file;
    if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
        file = context.getExternalFilesDir(null);
    } else {
        file = context.getFilesDir();
    }
    return file;
}