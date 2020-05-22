public class MeterReading implements Comparable {
    public static final int LOW = 0;
    public static final int MEDIUM = 1;
    public static final int HIGH = 2;

    private String name;
    private double level;

    ... // Constructor, getter setter and business logic methods

    public int getLevelClass() {
        if (level < 3) {
            return LOW;
        } else if (level < 6) {
            return MEDIUM;
        } else {
            return HIGH;
        }
    }

    public int compareTo(MeterReading m2) {
        return getLevelClass() - m2.getLevelClass();
    }
}