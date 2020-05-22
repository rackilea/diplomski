boolean interrupted;
long endWait = System.currentTimeMillis() + 3000;  // or 1000 * x
do {
    interrupted = false;
    long timeRemaining = endWait - System.currentTimeMillis();
    if (timeRemaining <= 0) {
        break;
    }
    try {
        Thread.sleep(timeRemaining);
    } catch (InterruptedException e) {
        ... what you need to do when interrupted
        interrupted = true;
    }
} while (interrupted);