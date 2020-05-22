time2.scheduleAtFixedRate(new TimerTask() {
            long t0 = System.currentTimeMillis();
            @Override
            public void run() {
              if (System.currentTimeMillis() - t0 > 10 * 1000) {
                  cancel();
              } else {
                  sendSamples();
              }
            }
...