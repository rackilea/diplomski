public enum Month {
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);

    private static final Map<Integer, Month> numberToMonthMap;

    private final int monthNum;

    static {
        numberToMonthMap = new HashMap<Integer, Month>();
        for (Month month : EnumSet.allOf(Month.class)) {
            numberToMonthMap.put(month.getMonthNum(), month);
        }
    }

    private Month(int monthNum) {
        this.monthNum = monthNum;
    }

    public int getMonthNum() {
        return monthNum;
    }

    public static Month fromMonthNum(int value) {
        Month ret = numberToMonthMap.get(value);
        if (ret == null) {
            throw new IllegalArgumentException(); // Or just return null
        }
        return ret;
    }
}