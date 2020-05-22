public void loop(Runnable arg) {
    long startTime;
    while(running) {
        startTime = System.currentTimeMillis();
        arg.run();
        try {
            long sleepTime = 1000/FPS - (System.currentTimeMillis() - startTime);
            if(sleepTime > 0)
                Thread.sleep(sleepTime);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}