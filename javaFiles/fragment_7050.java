/*
     * Step 1: Make a named pipe
     * Step 2: Open the pipe in Write only mode. Java code will open it in Read only mode.
     * Step 3: Make STDOUT i.e. 1, a duplicate of opened pipe file descriptor.
     * Step 4: Any writes from now on to STDOUT will be redirected to the the pipe and can be read by Java code.
     */
    int out = mkfifo(outfile, 0664);
    int fdo = open(outfile, O_WRONLY);
    dup2(fdo, 1);
    setbuf(stdout, NULL);
    fprintf(stdout, "This string will be written to %s", outfile);
    fprintf(stdout, "\n");
    fflush(stdout);
    close(fdo);