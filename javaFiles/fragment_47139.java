public void turnend() {
    if (leftover == 0) {
        housenumber = 1;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                //code1
                if (housenumber == 8) {
                    t.stopTimer();
                }
                //code 2
            }
        };
        t = new Timer(r, 500, true);
    }
}