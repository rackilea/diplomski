private class PostRequest implements Runnable {

  private String _postParam;

  public PostRequest(String param) {
    _postParam = param;
  }

  public void run() {
    // make POST request here, using _postParam
  }
}