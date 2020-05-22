public void sendTo(final String username, final String message) {
  if (!internalSendTo(username, message)) {
    // attempt resend
    ExecutorService exec = Executors.newSingleThreadExecutor();
    final AtomicBoolean result = new AtomicBoolean(false);
    exec.submit(new Runnable() {
      boolean b = internalSendto(username, message);
      result.set(b);
    });
    try {
      exec.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      // still didn't work
    } finally {
      exec.shutdownNow();
    }
  }
}

private boolean internalSendTo(String username, String message) {
  Userdata user = findUser(username);
  boolean success = false;
  if (user != null) {
    Out out = new Out(user.getClientSocket());
    // do the communication here
    success = true;
  }
  return success;
}