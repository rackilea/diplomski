// declare a timer variable in class level first!
timer = new Timer(1000 / UPDATE_RATE, new ActionListener() {
    // all your code in the while loop...
    // do not include the "while(true)" part
});
timer.start();