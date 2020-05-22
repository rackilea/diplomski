final int initialDt = 1000;
    final Handler handler = new Handler();
    final Runnable r = new Runnable() {
        int dt = initialDt;
        public void run() {
            dt -= 100;
            if (dt >= 0) {
                handler.postDelayed(this, dt);
            }
        }
    };
    handler.postDelayed(r, initialDt);