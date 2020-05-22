Server server;
boolean connected = false;
while (!connected) {
    server = serverQueue.poll();
    if (server == null) {
        return null;
    }
    try {
         server.makeConnection();
         connected = true;
    } catch (Exception e) {
         // Presumably log something here, for management info
    }
}