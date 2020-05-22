public static AppConfig getInstance() {
    if (mConfig != null) {
        return mConfig;
    } else {
        throw new RuntimeException("error");
    }
}