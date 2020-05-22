class ClientThread implements Runnable {
        @Override
        public void run() {
            try {
                socket = new Socket(ipServer, portServer);
            } catch (UnknownHostException e1) {
                threadMsg("Connection fails");
            } catch (IOException e1) {
                threadMsg("Connection fails");
            }
        }
    }