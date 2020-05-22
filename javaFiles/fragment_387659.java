java.util.concurrent.Executors.newSingleThreadExecutor().execute(new Runnable() {
  public void run() {
    ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c",
        scriptCMD);
    pb.redirectErrorStream(true);
    Process p = pb.start();
    BufferedReader r = new BufferedReader(new InputStreamReader(
        p.getInputStream()));
    String line;
    while (true) {
      line = r.readLine();
      if (line == null) {break;}
      System.out.println(line);
    }
  }
});