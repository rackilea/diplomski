public static void Simulation() {
    Setup();

    new Thread(new Runnable() {

        @Override
        public void run() {
            while (true) {
                Render();
                delay(10);
            }
        }
    }).start();
}