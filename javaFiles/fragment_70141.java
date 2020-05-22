Thread thread = new Thread(new Runnable(){
  @Override
  public void run(){
    HttpURLConnectionExample http = new HttpURLConnectionExample();
    System.out.println("Testing 1 - Send Http GET request");
    http.sendGet();
  }
});
thread.start();