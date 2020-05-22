Server server = serverQueue.poll();
boolean connected = false;
while (!connected) {
    if (server == null) {
        return null;
    }
    try {
         server.makeConnection();
         connected = true;
    } catch (Exception e) {
         // Presumably log something here, for management info

         // try another server
         server = serverQueue.poll();
    }
}