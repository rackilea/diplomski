public static void updateBouton() {
    th = new Thread() {
        public void run() {
//            for (int i = 0; i < 100; i++) {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(marche) {
                        bouton.setText("Pause " + ++count);
                    }
                }
//            }
        }
    };
    th.start();
}