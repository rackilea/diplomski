@Override
public void onPageFinished(WebView view, String url) {

  if (android.os.Build.VERSION.SDK_INT >= 21) flushCookies();
  else CookieSyncManager.getInstance().sync();
}

@TargetApi(21)
private void flushCookies() {

  CookieManager.getInstance().flush();
}