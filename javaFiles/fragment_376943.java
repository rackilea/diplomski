Thread thr = StreamGobbler.go(proc.getInputStream(), os);

    // wait for the exit
    try {
        final int exitVal = proc.waitFor();
        log.info("Command Exit Code: " + exitVal);
        thr.join();//waits for the gobbler that processes the stdout of the process
    } catch (InterruptedException e) {
        log.error("Interrupted while waiting for command to execute", e);
    }