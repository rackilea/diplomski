class ClickHandler implements Runnable {

        private static final long WAIT_DELAY = 250;

        private int count = 1;
        private long lastSubmitTime = System.currentTimeMillis();

        @Override
        public void run(){
            while(System.currentTimeMillis() - lastSubmitTime <= WAIT_DELAY) {
                // idle
                Thread.yield();
            }
            MyActivity.runOnUiThread(new Runnable(){

                @Override
                public void run(){
                    // fire event for counter
                    System.out.println("Count: " + count);
                }

            });

            // reset reference so we can start at 0
            handler = null;
        }

        public void recordNewClick(){
            count++;
            lastSubmitTime = System.currentTimeMillis();
        }

    }