class LogStore {
    private List<LogLine> loggingEvents = null;
    public LogStore(Class<? extends List> clazz) {
        try {
            @SuppressWarnings("unchecked")
            List<LogLine> logStoreList = clazz.newInstance();
            this.loggingEvents = logStoreList;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }       
    }
}