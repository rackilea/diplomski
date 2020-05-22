List<RelayThread> clients = new ArrayList<RelayThread>();
while (true) {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("I/O error: " + e);
        }
        // new thread for a client
        RelayThread relay = new RelayThread(socket,this);
        relay.start();
        clients.add(relay); 
   }