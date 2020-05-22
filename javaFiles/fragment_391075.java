int fps = 30;
int oneNanoSec = 1000000000;
int secondsPerLoop = oneNanoSecond/fps; //divide a second into 30 slices
while(game.isRunning()) {
    long start = System.nanoTime(); //see what time it is when we start

    game.update();
    game.render();

    long end = System.nanoTime(); //see what time it is when the game is finished updating/rendering
    long sleepTime = secondsPerLoop - (end-start);

    if(sleepTime > 0) {
        try {
            Thread.sleep(sleepTime);
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    } else
        Thread.yield();
}