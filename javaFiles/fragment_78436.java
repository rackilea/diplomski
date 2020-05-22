class Client {
        private Socket socket;
        private boolean tryToReconnect = true;
        private final Thread heartbeatThread;
        private long heartbeatDelayMillis = 5000;

        public Client(final String server, final int port) {
            connect(server, port);
            heartbeatThread = new Thread() {
                public void run() {
                    while (tryToReconnect) {
                        //send a test signal
                        try {
                            socket.getOutputStream().write(666);
                            sleep(heartbeatDelayMillis);
                        } catch (InterruptedException e) {
                            // You may or may not want to stop the thread here
                            // tryToReconnect = false;
                        } catch (IOException e) {
                            logger.warn("Server is offline");
                            connect(server, port);
                        }
                    }
                };
            };
            heartbeatThread.start();
        }

        private void connect(String server, int port){
            try {
                socket = new Socket(server, port);
            } catch (UnknownHostException e) {
                logger.error(e, e);
            } catch (IOException e) {
                logger.error(e, e);
            }
        }

        public void shutdown() {
            tryToReconnect = false;
        }
    }