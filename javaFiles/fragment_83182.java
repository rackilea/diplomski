public class MyClass {
    static class FilterA {
        int left = 4;
        int right = 40;
        int passes = 4;
    }
    private final FilterA filterA = new FilterA();

    static class DataFile {
        String path = "...";
        int channels = 4;
        int frequency = 300;
    }
    private final DataFile dataFile = new DataFile();

    private interface TimeRange {
        int from = 30;
        int to = 40;
    }
    private final TimeRange timeRange = new TimeRange();
}