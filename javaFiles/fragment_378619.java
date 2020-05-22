Handler h = new Handler();
void doWork() {
        h.postDelayed(new Runnable() {

            @Override
            public void run() {
                // do work here...
                if (!finish) {
                    doWork();
                }
            }
        }, 1000);
}