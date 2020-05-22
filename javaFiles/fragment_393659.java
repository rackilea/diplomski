public static void main(String[] args) {
    Thread t = new Thread() {
        public void run() {
            while (true) {
                try {
                    System.out.printf("working...\n");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.printf("interrupted\n");
                }
            }
        }

        @Override
        public synchronized void start() {
            try {
                init();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            super.start();
        }

        private void init() throws Exception {
            throw new Exception("test");
        }
    };

    t.start();
}