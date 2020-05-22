public boolean isValidURL(String urlStr) {
    try {
      URL url = new URL(urlStr);
      return true;
    }
    catch (MalformedURLException e) {
        return false;
    }
}