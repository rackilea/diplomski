ExecutorService exec = Executors.newCachedThreadPool();

Future<ReplyA> raFuture = exec.submit(new Callable<ReplyA>() {
  public ReplyA call() {
    // call remote service here.
    return new ReplyA(...);
  }});

Future<ReplyB> rbFuture = exec.submit(new Callable<ReplyB>() {
  public ReplyB call() {
    // call remote service here.
    return new ReplyB(...);
  }});

ReplyA replyA = raFuture.get();
ReplyB replyB = rbFuture.get();

exec.shutdown();