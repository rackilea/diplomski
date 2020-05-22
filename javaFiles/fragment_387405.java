public void TestCalendar() {
    Calendar nextYear = Calendar.getInstance();
    nextYear.add(Calendar.YEAR, 1);
    nextYear.getTime();
    log.info("Next Year: {}", getUTCMilliseconds(nextYear));

    Calendar now = Calendar.getInstance();
    log.info("Now: {}", getUTCMilliseconds(now));
}