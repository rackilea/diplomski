//method created for demonstration purposes
public Date getDateBeforeTwoWeeks(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DATE, -14); //2 weeks
    return calendar.getTime();
}