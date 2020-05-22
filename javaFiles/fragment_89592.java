private ArrayList<URL> download(final InputStream in, URL url, int maxDepth) throws IOException {
    ...
    for (final URL link : links) {
      //if exception is caught, loop will be broken here.........
      try{
        download(link.openStream(), link, maxDepth - 1);
      }
      catch (final IOException e) {
    // Display an error if anything fails.
    this.searchResults.append(e.getMessage());
      }
    }
    return alLinks;
}