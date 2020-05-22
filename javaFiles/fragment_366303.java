public static int executeCommandLine(final String commandLine,
                                     final boolean printOutput,
                                     final boolean printError,
                                     final long timeout)
      throws IOException, InterruptedException, TimeoutException {
  Runtime runtime = Runtime.getRuntime();
  Process process = runtime.exec(commandLine);
  /* Set up process I/O. */
  ... 
  Worker worker = new Worker(process);
  worker.start();
  try {
    worker.join(timeout);
    if (worker.exit != null)
      return worker.exit;
    else
      throw new TimeoutException();
  } catch(InterruptedException ex) {
    worker.interrupt();
    Thread.currentThread().interrupt();
    throw ex;
  } finally {
    process.destroyForcibly();
  }
}

private static class Worker extends Thread {
  private final Process process;
  private Integer exit;
  private Worker(Process process) {
    this.process = process;
  }
  public void run() {
    try { 
      exit = process.waitFor();
    } catch (InterruptedException ignore) {
      return;
    }
  }  
}