private void readInput() {
    ...

    int n = 0;
    try {
        n = source.read(buf);
    } catch (IOException ioe) {
        lastException = ioe;
        n = -1;
    }

    if (n == -1) {
        sourceClosed = true;
        needInput = false;
    }

    ...
}