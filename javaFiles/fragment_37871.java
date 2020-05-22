Process p = ...
if(!p.waitFor(1, TimeUnit.MINUTES)) {
    //timeout - kill the process. 
    p.destroyForcibly();
} else {
    int exitValue = p.exitValue();
    // ...
}