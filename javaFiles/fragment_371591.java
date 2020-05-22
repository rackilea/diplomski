ExecutorService executor = Executors.newFixedThreadPool(2);
Future<String> future1 = executor.submit(new SyncPipe(p.getErrorStream(), response.getOutputStream()),String.class);
Future<String> future2 = executor.submit(new SyncPipe(p.getErrorStream(), response.getOutputStream()),String.class);

future1.get();// will block the execution for you and the Thread completion
future2.get();