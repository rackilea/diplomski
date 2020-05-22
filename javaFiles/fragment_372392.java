public boolean isValidURI(String uriStr) {
    try {
      URI uri = new URI(uriStr);
      return true;
    }
    catch (URISyntaxException e) {
        return false;
    }
}