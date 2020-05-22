private static void setAllHandlersLevel(Level lvl) {
    LogManager lm = LogManager.getLogManager();
    synchronized (lm) {
        Enumeration<String> e = lm.getLoggerNames();
        while (e.hasMoreElements()) {
            Logger l = lm.getLogger(e.nextElement());
            if (l != null) {
                for (Handler h : l.getHandlers()) {
                    h.setLevel(lvl);
                }
            }
        }
    }
}