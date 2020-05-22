public boolean shouldOverrideUrlLoading(WebView view, String url) {
    if (url.endsWith(".mp3")) { //or whatever other extension
      //Prompt user for action (save or view)
    }
    return false;
 }