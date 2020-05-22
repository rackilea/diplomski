@Component(provide = {}, immediate = true) public class Logger extends Thread
    implements LogListener {
  final BlockingQueue<LogEntry> queue = new ArrayBlockingQueue<LogEntry>(1000);
  File root;

  @Reference void setLR(LogReaderService lr) {
    lr.addLogListener(this);
  }

  @Activate void activate(BundleContext context, Map<String,Object> props) {
    if ( props.containsKey("root"))
      root = new File((String) props.get("root"));
    else
      root = context.getDataFile("logs");
    root.mkdirs();
    start();
  }

  @Deactivate void deactivate() {
    interrupt();
  }

  @Override public void logged(LogEntry entry) {
    queue.offer(entry); // ignore full silently
  }

  public void run() {
    while (true)
      try {
        LogEntry entry = queue.take();
        File file = getPath(entry);

        if (file.isFile()) {
          long days = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis()
              - file.lastModified());
          if (days > 2) file.delete();
        }

        try (OutputStream raf = new FileOutputStream(file, true)) {
          String s = String.format("%tT [%03d] %s%n", entry.getTime(), entry
              .getBundle().getBundleId(), entry.getMessage());
          raf.write(s.getBytes("UTF-8"));
        }

      } catch (InterruptedException ie) {
        return;
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
  }

  private File getPath(LogEntry entry) {
    long rollover = TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis()) % 7;
    String eba = "eba"; // fill in eba from entry.getBundle()?
    return new File(root, "log-" + eba + "-" + rollover + ".msg");
  }
}