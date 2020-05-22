long timeoutInMillis = 1000;

try {
    Thread monitor = ThreadMonitor.start(timeoutInMillis);  
    // do some work here
    ThreadMonitor.stop(monitor);
} catch (InterruptedException e) {
    // timed amount was reached
}