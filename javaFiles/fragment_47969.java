public void run() {
  Connection conn = DriverManager.getConnection(...);
  while (true) {
     DBRunnable task=queue.take();
     task.run(conn);
  }
}