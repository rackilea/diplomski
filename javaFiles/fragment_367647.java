public String toString() {
    // "EEE MMM dd HH:mm:ss zzz yyyy";
    BaseCalendar.Date date = normalize();
    StringBuilder sb = new StringBuilder(28);
    int index = date.getDayOfWeek();
    if (index == gcal.SUNDAY) {
        index = 8;
    }
    ....  // some more code
}