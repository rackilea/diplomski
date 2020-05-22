public static String getDay(String day, String month, String year) {
    String[] dates = new String[] { "SUNDAY", "MONDAY", "TUESDAY", //
            "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY" };
    Calendar cal = Calendar.getInstance();
    cal.set(Integer.parseInt(year), //
            Integer.parseInt(month) - 1, // <-- add -1
            Integer.parseInt(day));
    int date_of_week = cal.get(Calendar.DAY_OF_WEEK);
    return dates[date_of_week - 1];
}