public synchronized void mark(int readlimit) {
}

public synchronized void reset() throws IOException {
    throw new IOException("mark/reset not supported");
}