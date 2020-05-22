public void plotGraphs() {
    runOnUiThread(new Runnable() {
        public void run() {
            addEntryGraph0();
            addEntryGraph1();
            addEntryGraph2();
            addEntryGraph3();
            addEntryGraph4();
            addEntryGraph5();
            ch0Buffer.subList(0, 100).clear();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });
}