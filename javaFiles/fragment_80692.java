public void write(String s, int off, int len) throws IOException {

    synchronized (lock) {

        ensureOpen();

        int b = off, t = off + len;

        while (b < t) {

            int d = min(nChars - nextChar, t - b);
            s.getChars(b, b + d, cb, nextChar);
            b += d;
            nextChar += d;

            if (nextChar >= nChars)
                flushBuffer();
            }
        }
    }
}