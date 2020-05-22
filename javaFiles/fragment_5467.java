.............
 public InputStream openContentStream() {
    String contents =
        "This is the initial file contents for *.ej file that should be word-sorted in the Preview page of the multi-page editor";
    if(page.getContent()!=null) {
        return new ByteArrayInputStream(page.getContent().getBytes());
    }
    return new ByteArrayInputStream(contents.getBytes());
}
  ............