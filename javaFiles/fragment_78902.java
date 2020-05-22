private void receive() {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        process(in.readUTF());
                        in.close(); // remove this
                        sleep(100);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        t.start();
    }