Callable<Reply> taskA = new Callable<ReplyA>() { ... };
Callable<Reply> taskB = new Callable<ReplyB>() { ... };

List<Callable<Reply>> tasks = Arrays.asList(taskA, taskB);
List<Future<Reply>> futures = exec.invokeAll(tasks, 20, TimeUnit.SECONDS);

for(Future<Reply> future: futures) {
  if(replyFuture.isCancelled()) {
    // deal with it
  } else {
    Reply reply = future.get();
    // do something with the reply.
  }
}