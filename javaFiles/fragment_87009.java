public static void InitializeObserver(Context c) {
    try {
        ContentResolver contentResolver = c.getContentResolver();
        Handler mSmsObserverHandler = new Handler(Looper.getMainLooper());
        SmsObserver mSmsObserver = new SmsObserver(mSmsObserverHandler, c);
        contentResolver.registerContentObserver(Uri.parse("content://sms/"), true, mSmsObserver);
    } catch (Exception e) {
    }
}