browser.setWebConnection(new WebConnectionWrapper(browser) {
  public WebResponse getResponse(final WebRequest request) throws IOException {
    WebResponse response = super.getResponse(request);
    //processResponse
    return response;
 }
});