Configuration config = new Configuration();
config.setHostname("localhost");
config.setPort(81);

SocketIOServer server = new SocketIOServer(config);
server.start();