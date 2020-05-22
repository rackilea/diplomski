boolean shouldDoSomething;
synchronized {
    ++threadCounter;
    if (threadCounter == 4) {
        threadCounter = 0;
        shouldDoSomething = true;
    }
    else {
        shouldDoSomething = false;
    }
}
if (shouldDoSomething) doSomething();