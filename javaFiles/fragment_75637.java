ServerSocket ss = new ServerSocket(8123);

    new Thread() {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                ss.close();
            } catch(InterruptedException e) {
            } catch(IOException e) {
            }
        }
    }.start();
    Socket s = ss.accept();