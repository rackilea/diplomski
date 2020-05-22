/*
     * Step 1: Make a named pipe
     * Step 2: Open the pipe in Read only mode. Java code will open it in Write only mode.
     * Step 3: Make STDIN i.e. 0, a duplicate of opened pipe file descriptor.
     * Step 4: Any reads from STDIN, will be actually read from the pipe and JAVA code will perform write operations.
     */
    int in = mkfifo(infile, 0664);
    int fdi = open(infile, O_RDONLY);
    dup2(fdi, 0);
    char buf[256] = "";
    fscanf(stdin, "%*s %99[^\n]", buf); // Use this format to read white spaces.
    close(fdi);