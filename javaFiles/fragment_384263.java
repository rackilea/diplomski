ServerSocket ss;
try {
    ss = new ServerSocket(MY_PORT);
    // not already running.
} catch (BindException e) {
    // already running.
}