@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
// Check if the key event was the Back button and if there's history
if ((keyCode == KeyEvent.KEYCODE_BACK) && myWebView.canGoBack()) {
    myWebView.goBack();
    return true;
}
// If it wasn't the Back key or there's no web page history, bubble up to the default
// system behavior (probably exit the activity)
return super.onKeyDown(keyCode, event);
}