class Logger {
    private final BufferedWriter w;

    public Logger(final File file) throws IOException {
        this.w = new BufferedWriter(new FileWriter(file));
        LoggerRegistry.register(this);
    }

    public void log(String s) throws IOException {
        synchronized (this.w) {
            this.w.write(s);
            this.w.write("\n");
        }
    }

    public void close() throws IOException {
        this.w.close();
    }
}