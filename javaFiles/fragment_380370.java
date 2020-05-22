public void myMagicCode() {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        methodThatUsesClipboardManager();
    }
}

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
protected void methodThatUsesClipboardManager() {
    ClipboardManager instance = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
    //use the instance
}