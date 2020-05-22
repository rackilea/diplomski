public static void startServer() throws IOException {
    // don't ignore the server failing to bind.
    final ServerSocket ss = new ServerSocket(12345);

    final int parallelism = Runtime.getRuntime().availableProcessors();
    // add one for the acceptor
    final ExecutorService pool = ExecutorService.newFixedThreadPool(parallelism+1);

     pool.submit(() -> {
         try {
             while (!ss.isClosed())
                 pool.submit(new Handler(serverSocketChannel.accept()));
         } catch (IOException ignored) {
     });
}

class Handler implements Runnable {
   static final ThreadLocal<ExpensiveObject> expensiveObjectIWantToReuse = new ThreadLocal<>();

   final Socket s;
   final DataInputStream in;
   final DataOutputStream out;

   Handler(Socket s) {
      this.s = s;
      this.in = new DataInputStream(new BufferedInputStream(s.getInputStream()));
      this.out = new DataOutputStream(new BufferedOutputStream(s.getOutputStream()));
   }

   public void run() {
      try {
          processStream(in, out);
      } catch (Throwable t) {
          // log t
      } finally (
          close(out);  // also flush()es
          close(in);
          close(s);
      }
   }

   public static void close(Closable c) {
      try {
          if (c != null) c.close();
      } catch (IOException ignored) { }
   }

   protected void processStream(DataInput di, DataOutput out) {
      // do something
   }