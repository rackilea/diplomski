new Thread() {
  public void run() {
    try {
      while (true) {
        System.out.println(dis.readUTF());
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
  }
}.start();