public static String formatToYesterdayOrToday(String date) throws ParseException {
    Date dateTime = new SimpleDateFormat("EEE hh:mma MMM d, yyyy").parse(date);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(dateTime);
    Calendar today = Calendar.getInstance();
    Calendar yesterday = Calendar.getInstance();
    yesterday.add(Calendar.DATE, -1);
    DateFormat timeFormatter = new SimpleDateFormat("hh:mma");

    if (calendar.get(Calendar.YEAR) == today.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)) {
        return "Today " + timeFormatter.format(dateTime);
    } else if (calendar.get(Calendar.YEAR) == yesterday.get(Calendar.YEAR) && calendar.get(Calendar.DAY_OF_YEAR) == yesterday.get(Calendar.DAY_OF_YEAR)) {
        return "Yesterday " + timeFormatter.format(dateTime);
    } else {
        return date;
    }
}