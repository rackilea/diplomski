public class FileWalker implements Iterator<Path> {
  final BlockingQueue<Path> bq;
  FileWalker(final File fileStart, final int size) throws Exception {
  bq = new ArrayBlockingQueue<Path>(size);
  Thread thread = new Thread(new Runnable() {
    public void run() {
      try {
        Files.walkFileTree(fileStart.toPath(), new FileVisitor<Path>() {
          public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            return FileVisitResult.CONTINUE;
          }
          public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            try {
              bq.offer(file, 4242, TimeUnit.HOURS);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
            return FileVisitResult.CONTINUE;
          }
          public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
          }
          public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
          }
        });
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  });
  thread.setDaemon(true);
  thread.start();
  thread.join(200);
}
public Iterator<Path> iterator() {
  return this;
}
public boolean hasNext() {
  boolean hasNext = false;
  long dropDeadMS = System.currentTimeMillis() + 2000;
  while (System.currentTimeMillis() < dropDeadMS) {
    if (bq.peek() != null) {
      hasNext = true;
      break;
    }
    try {
      Thread.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  return hasNext;
}
public Path next() {
  Path path = null;
  try {
    path = bq.take();
  } catch (InterruptedException e) {
    e.printStackTrace();
  }
  return path;
}
public void remove() {
  throw new UnsupportedOperationException();
}
}