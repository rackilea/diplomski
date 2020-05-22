@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public int setVoice21(@NonNull final String language, @NonNull final String region) {
    try {
        // try some API 21 stuff
        new Locale.Builder().build().getDisplayVariant();
    } catch (final IllformedLocaleException ex) {
        ex.printStackTrace();
    }
    return 0;
}