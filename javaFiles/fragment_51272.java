public static File getExternalStorageDirectory(Context context) {
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
        //noinspection deprecation
        return Environment.getExternalStorageDirectory();
    } else {
        try {
            File file = getAppFileDir(context);
            if (null != file) {
                //noinspection ConstantConditions
                return file.getParentFile().getParentFile().getParentFile().getParentFile();
            } else {
                return new File("");
            }
        } catch (Throwable e) {
            e.printStackTrace();
            return new File("");
        }
    }
}