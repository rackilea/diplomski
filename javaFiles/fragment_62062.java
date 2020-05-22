try {
    n = source.read(buf);
} catch (IOException ioe) {
    lastException = ioe;
    n = -1;
}