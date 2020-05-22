private static SimpleDateFormat fmt = new SimpleDateFormat("E");

public static void main(String[] args) throws Exception {
    // Put the days in the list into a sorted set
    TreeSet<Integer> daySet = new TreeSet<Integer>();
    for (String day : "Sun,Mon,Tue,Fri,Sat".split(",")) {
        daySet.add(dayOfWeek(day));
    }

    // Find the next day in the list, starting from today
    Calendar cal = Calendar.getInstance();
    int today = cal.get(Calendar.DAY_OF_WEEK);
    cal.set(Calendar.DAY_OF_WEEK, findNext(daySet, today));
    System.out.println(fmt.format(cal.getTime()));
}

/**
 * Parses a day name, and returns the number of the day in the week.
 */
private static int dayOfWeek(String day) {
    Calendar cal = Calendar.getInstance();
    cal.setTime(fmt.parse(day, new ParsePosition(0)));
    return cal.get(Calendar.DAY_OF_WEEK);
}

/**
 * Finds a value in the sorted set that is greater than 'from'.
 * If there are no greater values, return the first value.
 */
private static int findNext(SortedSet<Integer> set, int from) {
    SortedSet<Integer> tail = set.tailSet(Integer.valueOf(from));
    return tail.isEmpty() ? set.first() : tail.first();
}