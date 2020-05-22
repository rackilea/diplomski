public class ReportHolder {
    private static ConcurrentMap<String, Example> map = new ConcurrentMap<>();
    public static Example getReport(final String id) {
        return map.get(id);
    }
}