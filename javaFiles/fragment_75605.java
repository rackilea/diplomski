public class TidyFileAppender<E> extends FileAppender<E> {

  protected File directory;

  @Override
  public void start() {
    if (conditions to determine historical files to be deleted) {
      File[] oldFiles = directory.listFiles(new FileFilter() {
        @Override
        public boolean accept(File file) {
          // return true if file is 'old'
        }
      });
      if (oldFiles != null) {
        for (File oldFile : oldFiles) {
          if (!oldFile.delete()) {
            addWarn("Failed to delete old log file: " + oldFile);
          }
        }
      }
    } else {
      addWarn("Cannot tidy historical logs...");
    }
    super.start();
  }
}