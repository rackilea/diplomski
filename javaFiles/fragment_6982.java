public class TimeComparator {
    private static final long DIVISOR = 24 * 60 * 60 * 1000L;

    public static int compare(Time t1, Time t2) {
        int v1 = (int)(t1.toMillis(true) % DIVISOR),
            v2 = (int)(t2.toMillis(true) % DIVISOR);

        return v1 - v2;
    }

    public static boolean before(Time t1, Time t2) {
        return compare(t1, t2) < 0;
    }

    public static boolean equals(Time t1, Time t2) {
        return compare(t1, t2) == 0;
    }

    public static boolean after(Time t1, Time t2) {
        return compare(t1, t2) > 0;
    }
}