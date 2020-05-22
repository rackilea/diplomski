public boolean shouldOverrideUrlLoading(WebView view, String url) {
  if (url.endsWith("&like")) {
    NetworkOperations.addlike(url);
    return false;
  } else {
    return true;
  }
}