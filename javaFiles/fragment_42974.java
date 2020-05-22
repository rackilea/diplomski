public void run() throws NullPointerException {
    while (true) {
        // !! This is wrong !!
        // Each clock should have its own concept of it's start time, then each "second" you
        // should advance the time by a single second...
        s = new Date().getSeconds();//+incre.getSeconds();