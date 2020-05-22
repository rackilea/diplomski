public boolean validateTime(String timeString) {
    if (timeString.length() != 5) return false;
    if (!timeString.substring(2, 3).equals(":")) return false;
    int hour = validateNumber(timeString.substring(0, 2));
    int minute = validateNumber(timeString.substring(3));
    if (hour < 0 || hour >= 24) return false;
    if (minute < 0 || minute >= 60) return false;
    return true;
}

public int validateNumber(String numberString) {
    try {
        int number = Integer.valueOf(numberString);
        return number;
    } catch (NumberFormatException e) {
        return -1;
    }
}