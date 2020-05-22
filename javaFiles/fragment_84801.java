public enum Day {
    SUNDAY("Sunday", 0)
,   MONDAY("Monday", 1)
,   TUESDAY("Tuesday", 2)
,   WEDNESDAY("Wednesday", 3)
,   THURSDAY("Thursday", 4)
,   FRIDAY("Friday", 5)
,   SATURDAY("Saturday", 6);

    private String name;
    private int ordinal;
    public String getName() { return name; }
    public int getOrdinal() { return ordinal; }
    public Day(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }
}