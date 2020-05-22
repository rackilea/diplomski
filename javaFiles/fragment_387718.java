public static void printLoggerTree() {
    final LogManager manager = LogManager.getLogManager();
    synchronized (manager) {
        final Enumeration<String> e = manager.getLoggerNames();
        while (e.hasMoreElements()) {
            final Logger l = manager.getLogger(e.nextElement());
            if (l != null) {
                for (Handler h : l.getHandlers()) {
                    System.out.println(l.getName() + "=" + h);
                }
            }
        }
    }
}