void blink(final int delay, final int times) {
    Thread t = new Thread(new Runnable() {
        @Override
        public void run() {

            try {

                for (int i=0; i < times*2; i++) {
                    if (isFlashOn) {
                        turnOffFlash();
                    } else {
                        turnOnFlash();
                    }
                    Thread.sleep(delay);
                }

            } catch (Exception e){
                e.printStackTrace();
            }

        }
    });

    t.start();
}