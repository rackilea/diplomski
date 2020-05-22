while(!MyReceiver.serverSocket.isClosed()){
        Socket server = null;
        try {
            server = MyReceiver.serverSocket.accept();
            //System.out.println("Just connected to " + server.getRemoteSocketAddress());
            logger.info("Just connected to " + server.getRemoteSocketAddress());
            MyReceiver.mapConnections.put(server.getRemoteSocketAddress().toString().trim(), "");

            if (activeConnections == maxConnections) break; // exit accept loop