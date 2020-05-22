public void throwIfReached() throws IOException {
    if (Thread.interrupted()) {
        throw new InterruptedIOException("thread interrupted");
    }

    if (hasDeadline && deadlineNanoTime - System.nanoTime() <= 0) {
        throw new InterruptedIOException("deadline reached");
    }
}