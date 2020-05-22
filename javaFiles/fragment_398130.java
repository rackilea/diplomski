Server server = new Server();

server.setDatabaseName(0, "test");
server.setDatabasePath(0, "file:test");
server.setLogWriter(new PrintWriter(System.out));
server.setErrWriter(new PrintWriter(System.err));
server.start();