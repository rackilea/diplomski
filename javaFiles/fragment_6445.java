public Date roundToNextWholeHour(Date date) {
    Calendar c = new GregorianCalendar();
    c.setTime(date);
    c.add(Calendar.HOUR, 1);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    return c.getTime();
}