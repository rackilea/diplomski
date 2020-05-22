public class Day /* extends Enum */ {
    public static final Day MONDAY = new Day("MONDAY", 0);
    public static final Day TUESDAY = new Day("TUESDAY", 1);

    private static final Day[] values = { MONDAY, TUESDAY };
    private static final Map<String, Day> valueOfMap = new HashMap();

    public static Day[] values() { return values.clone(); }
    public static Day valueOf(String name) {
        Day day = valueOfmap.get(name);
        if(day == null) throw new IllegalArgumentException(name);
        return day;
    }

    private final String name;
    private final int ordinal;

    private Day(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
        valueOfMap.put(name, this);
    }
    public String name() { return name; }
    public int ordinal() { return ordinal; }
    public String toString() { return name; }
}

public class Other {
    Day day = Day.MONDAY;
}