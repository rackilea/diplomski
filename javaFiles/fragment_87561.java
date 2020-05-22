public String getDifference() {
    difference = (time2.getTime() - time1.getTime()) / 1000L;
    long hours = difference/3600;
    difference %= 3600;
    long minutes = difference/60;
    difference %= 60;
    long seconds = difference;

    return String.format("%d:%02d:%02d", hours, minutes, seconds);
}