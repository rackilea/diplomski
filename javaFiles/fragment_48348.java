public void serverLoopMethod() {
     while (weAcceptConnections) {
        Connection connection = accept(...);
        threadPool.submit(new ConnectionHandler(connection);
     }
 }
 ...
 private static class ConnectionHandler implements Runnable {
     private Connection connection;
     public ConnectionHandler(Connection connection) {
         this.connection = connection;
     }
     // run (or call) method executed in another thread
     public void run() {
         try {
            // work with the connection probably by calling other methods
         } finally {
              // connection is closed at the end of the thread run method
              connection.close();
         }
     }
 }