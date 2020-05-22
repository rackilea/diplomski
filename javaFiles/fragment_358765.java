Process p = Runtime.getRuntime().exec("/bin/sh /var/task/bin/iTMSTransporter " + commandLine);
try {
    p.waitFor();
    // now, the process has terminated
} catch (InterruptedException e) {
    // something went wrong
    e.printStackTrace();
}