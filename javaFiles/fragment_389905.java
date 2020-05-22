try {
    System.out.println("Hello");
    new Thread(new Runnable() {
        public void run() {
packetListener.listener();
            }
    }).start();         

        } catch (Exception e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }