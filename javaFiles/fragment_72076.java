long targetTime = 1000/FPS;

while (...) {
    startTime = System.nanoTime();
    ... do lots of work ...
    timeMills = (System.nanoTime() - startTime) / 1000000;
    waitTime = targetTime - timeMills;