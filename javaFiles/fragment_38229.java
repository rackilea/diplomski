new Thread() {
            public void run() {

                try {
                    sleep(900);
                    mSoundManager.playSound(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }.start();