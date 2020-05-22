class LoggerRegistry {
    private final static List<Logger> loggers = new ArrayList<Logger>();

    public static void register(Logger l) {
        loggers.add(l);
    }

    public static void close() {
        for (Logger l : loggers) {
            try {
                l.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}