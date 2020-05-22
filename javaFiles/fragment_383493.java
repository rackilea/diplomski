public void run() throws InterruptedException {

    double ups = 60;
    double fps = 60;

    long initialTime = System.nanoTime();
    final double timeU = 1000000000 / ups;
    final double timeF = 1000000000 / fps;
    double deltaU = 0, deltaF = 0;
    int frames = 0, ticks = 0;
    long timer = System.currentTimeMillis();

    while (isRunning) {

        long currentTime = System.nanoTime();
        deltaU += (currentTime - initialTime) / timeU;
        deltaF += (currentTime - initialTime) / timeF;
        initialTime = currentTime;

        if (deltaU >= 1) {
            Thread.sleep(rnd.nextInt(32));
            //getInput();   
            //update();
            ticks++;
            deltaU--;
        }

        if (deltaF >= 1) {
            Thread.sleep(rnd.nextInt(32));
            //render();
            frames++;
            deltaF--;
        }

        if (System.currentTimeMillis() - timer > 1000) {
            System.out.println(String.format("UPS: %s, FPS: %s", ticks, frames));
            frames = 0;
            ticks = 0;
            timer += 1000;
        }
    }
}