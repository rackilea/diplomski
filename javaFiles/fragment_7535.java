public class CheckPort implements Runnable {
        private boolean checkPort = true;

        public void run() {
            while( checkPort ) {
                checkPort();
                try {
                    Thread.sleep( 100 );
                } catch( InterruptedException ex ) {
                }
            }
        }

        public void checkPort() {
            // do check port here
        }

        public void stop() {
            checkPort = false;
        }
    }