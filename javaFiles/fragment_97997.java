void findServers(int howMany) {
    // code run on the Swing event thread
    Main.chatGraphics.log("<font face='arial' color='yellow'>Searching for servers...</font>");
    Main.chatGraphics.msgInputTF.setText("Wait...");
    Main.chatGraphics.msgInputTF.setEnabled(false);

    // code run in background thread, that returns our List of interest
    new SwingWorker<List<String>, Void>() {

        @Override
        public List<String> doInBackground() throws Exception {

            // the List should be declared local within the worker
            List<String> servers = new ArrayList<>();
            Socket newSocket;
            for (int i = 2; i < 254; i++) {
                if (servers.size() >= howMany) {
                    break;
                }

                // don't catch exceptions wihin the worker. Do this in the
                // done() method.
                newSocket = new Socket();
                InetSocketAddress isa = new InetSocketAddress("192.168.1." + i,
                        Main.DEFAULT_PORT);
                if (isa.isUnresolved())
                    continue;
                newSocket.connect(isa, 10);
                servers.add(newSocket.getInetAddress().getHostAddress());
            }
            return servers;
        }

        @Override
        public void done() {
            try {
                // call the worker's get() method to retrieve the List
                // and to capture any exceptions
                List<String> servers = get();
                if (servers.size() == 0) {
                    Main.chatGraphics.log("<font face='arial' color='red'>No available servers</font>");
                }

                Main.chatGraphics.msgInputTF.setEnabled(true);
                Main.chatGraphics.msgInputTF.setText("");
                Main.chatGraphics.msgInputTF.grabFocus();


                // *** use servers in the GUI **here**


            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();

                // you will need more robust exception handling here
                // including extracting from this the true
                // underlying exception that was called
            }
        }
    }.execute();
}