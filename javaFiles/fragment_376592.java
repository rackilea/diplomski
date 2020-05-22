Process p = ...
try {
    Thread.sleep(5 * 1000);
    int exitValue = p.exitValue();
    // get the process results here
} catch (IllegalThreadStateException e) {
    // process hasn't terminated in 5 sec
    p.destroy();
}