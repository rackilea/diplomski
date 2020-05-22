public static class Handler implements Runnable {
    private Socket client;  
    private UserSession session;

    public Handler(Socket client) {
      this.client = client;
      this.session = new UserSession();
    }
 ...