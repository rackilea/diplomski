private long startTime, endTime;
private Timer timer;

// When you need to start your timer, do-
startTime = System.currentTimeMillis();
if (timer == null) {
    timer = new Timer(100, this);
    timer.start();
} else {
    timer.restart()
}

// When the button is pressed
endTime = System.currentTimeMillis();
timer.stop();

double totalSeconds = (endTime - startTime) / 1000.0;

// To know how long it's been running-
long time = (System.currentTimeMillis() - startTime) / 1000;