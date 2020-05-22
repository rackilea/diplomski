public void close() {
    try {
        synchronized (lock) {
            if (out == null)
                return;
            out.close();
            out = null;
        }
    }
    catch (IOException x) {
        trouble = true;
    }
}