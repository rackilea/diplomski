public String formatMinutesInConversationalTone(AlarmClock clock) {
    if (clock == null) {
        throw new IllegalArgumentException("clock cannot be null");
    }

    int minutes = clock.getMinutes();
    if (minutes == 0) {
        return "It is the top-of-the-hour";
    }

    if (minutes == 30) {
        return "It is half past the hour";
    }

    if (minutes < 30) {
        return String.format("It is %d minutes past the hour", minutes);
    }

    return String.format("It is %d minutes before the hour", (60 - minutes));
}