class DB {

    // The private method that can emulate both public methods:
    private Map<Date, Result> executeImpl(
        Date d0, Date d1, Map<Date, Result> results);

    // The implementation that returns a new map
    public Map<Date, Result> execute(Date d0, Date d1) {
        return executeImpl(d0, d1, null);
    }

    // The implementation that fills a given map
    public void execute(Date d0, Date d1, Map<Date, Result> results) {
        executeImpl(d0, d1, results);
    }

}