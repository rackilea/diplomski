class SharedPreferencesUserUploadHelper implements UserUploadHelper {
    private static final String LAST_IMAGE_UPLOAD_TIME = "last.user.upload.time";
    private static final String PREFS_NAME = "user.upload";
    private static final String PREFS_MODE = Context.MODE_PRIVATE;
    private static final String MILLIS_IN_DAY = 24 * 60 * 60 * 1000;

    private final SharedPreferences sharedPreferences;

    SharedPreferencesUserUploadHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, PREFS_MODE);
    }

    @Override
    void userUploadedImage() {
        sharedPreferences.edit().putLong(
            LAST_IMAGE_UPLOAD_TIME, 
            new Date().getTime()
        ).apply();
    }

    @Override
    boolean canUserUploadImages() {
        long lastUploadTime = sharedPreferences.getLong(LAST_IMAGE_UPLOAD_TIME, 0L);
        long now = new Date().getTime();
        return lastUploatTime - now > MILLIS_IN_DAY;
    }
}