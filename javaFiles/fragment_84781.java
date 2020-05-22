Process p = Runtime.getRuntime().exec("subl "+ temp.getAbsolutePath());
try {
    p.waitFor();
    // display tmp contents...
} catch (InterruptedException exc) {
    // thread was interrupted waiting for process to complete...
}