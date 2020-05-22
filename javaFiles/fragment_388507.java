public static void main(String[] args) throws IOException {
    try {
        final Logger l = new Logger(new File("/tmp/1"));
        l.log("Hello");

        // ... 

    } finally {
        LoggerRegistry.close();
    }
}