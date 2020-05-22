public static String formatToYesterdayOrToday(String date) {
    DateTime dateTime = DateTimeFormat.forPattern("EEE hh:mma MMM d, yyyy").parseDateTime(date);
    DateTime today = new DateTime();
    DateTime yesterday = today.minusDays(1);
    DateTimeFormatter timeFormatter = DateTimeFormat.forPattern("hh:mma");

    if (dateTime.toLocalDate().equals(today.toLocalDate())) {
        return "Today " + timeFormatter.print(dateTime);
    } else if (dateTime.toLocalDate().equals(yesterday.toLocalDate())) {
        return "Yesterday " + timeFormatter.print(dateTime);
    } else {
        return date;
    }
}