public class Shell {
  final Holder<String> status = new Holder<>();
  Runtime rtime;
  Process process;

  public void runCmd(final String cmd, String status) throws Exception {
    // Set the status.
    Shell.this.status.hold(status);
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        try {
          process = rtime.exec(cmd);
          process.waitFor();
          Shell.this.status.hold("check out done");
        } catch ( IOException | InterruptedException e) {
        }
      }

    });

    t.start();

  }

}