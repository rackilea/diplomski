private static final int LENGTH_OF_WEEK = 7 * 24 * 60 * 60 * 1000;

public static int weekOf(Calendar yearStart, Calendar date) {
    long millisElapsed = date.getTimeInMillis() - yearStart.getTimeInMillis();
    int weeksElapsed = (int) (millisElapsed / LENGTH_OF_WEEK);
    return weeksElapsed + 1;
}