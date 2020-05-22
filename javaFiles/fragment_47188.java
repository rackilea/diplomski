public static void main(String[] args) {
    Calendar cal = Calendar.getInstance();
    int nowHour = cal.get(Calendar.HOUR_OF_DAY);
    int nowMin  = cal.get(Calendar.MINUTE);
    System.out.printf("Now is: %02d:%02d%n", nowHour, nowMin);
    test(nowHour, nowMin, "00:00");
    test(nowHour, nowMin, "01:00");
    test(nowHour, nowMin, "11:59");
    test(nowHour, nowMin, "12:00");
    test(nowHour, nowMin, "23:08");
    test(nowHour, nowMin, "23:59");
}
private static void test(int nowHour, int nowMin, String endTime) {
    Matcher m = Pattern.compile("(\\d{2}):(\\d{2})").matcher(endTime);
    if (! m.matches())
        throw new IllegalArgumentException("Invalid time format: " + endTime);
    int endHour = Integer.parseInt(m.group(1));
    int endMin  = Integer.parseInt(m.group(2));
    if (endHour >= 24 || endMin >= 60)
        throw new IllegalArgumentException("Invalid time format: " + endTime);
    int minutesLeft = endHour * 60 + endMin - (nowHour * 60 + nowMin);
    if (minutesLeft < 0)
        minutesLeft += 24 * 60; // Time passed, so time until 'end' tomorrow
    int hours = minutesLeft / 60;
    int minutes = minutesLeft - hours * 60;
    System.out.println(hours + "h " + minutes + "m until " + endTime);
}