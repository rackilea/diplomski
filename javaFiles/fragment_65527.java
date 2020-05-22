private Date getDateWithOutTime(Date targetDate) {
    Calendar newDate = Calendar.getInstance();
    newDate.setLenient(false);
    newDate.setTime(targetDate);
    newDate.set(Calendar.HOUR_OF_DAY, 0);
    newDate.set(Calendar.MINUTE,0);
    newDate.set(Calendar.SECOND,0);
    newDate.set(Calendar.MILLISECOND,0);

    return newDate.getTime();

}