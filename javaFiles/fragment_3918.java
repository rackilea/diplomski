private static int getInSeconds(javax.xml.datatype.Duration duration) {
    int totalSeconds = 0;
    totalSeconds += duration.getSeconds();
    totalSeconds += (duration.getMinutes() * 60);
    totalSeconds += (duration.getHours() * 60 * 60);
    totalSeconds += (duration.getDays() * 24 * 60 * 60);
    // ... calculate values for other fields here, too
    return totalSeconds;
}