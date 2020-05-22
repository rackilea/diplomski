InputStream  fis = Files.newInputStream (sourcePath);
OutputStream fos = Files.newOutputStream(sinkPath);

final Runnable runnable = new Runner(fis, fos);
final Thread   thread   = new Thread(runnable);
thread.start();