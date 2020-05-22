public void turnend() {
        final Runnable callback = new Runnable() {
            @Override
            public void run() {
                //code 2
            }
        };

        if (leftover == 0) {
            housenumber = 1;
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    //code1
                    if (housenumber == 8) {
                        t.stopTimer();
                    }
                    callback.run();
                }
            };
            t = new Timer(r, 500, true);
        }
    }