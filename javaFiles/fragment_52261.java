public static MySingleton getInstance(final Context context) {
    if(sInstance == null) {
        sInstance = new MySingleton(context.getApplicationContext());
    }

    return sInstance;
}