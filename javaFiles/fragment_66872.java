public int compareTo(DateKeeper toCompare) {
    Calendar startDate = getAsCalendar();
    Calendar endDate = toCompare.getAsCalendar();
    long diff = (endDate.getTimeInMillis()/ (1000 * 60 * 60 * 24)) - (startDate.getTimeInMillis()/ (1000 * 60 * 60 * 24));//in Milli seconds
    return (int) diff;
}