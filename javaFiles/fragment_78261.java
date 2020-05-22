public static String getValue(String s) {
    String[] splitted = s.split(":");
    int hour = Integer.parseInt(splitted[0]);
    if (hour < 8) {
        hour += 12;
        splitted[0] = String.valueOf(hour);
    }
    return splitted[0] + ":" + splitted[1];
}