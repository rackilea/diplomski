public Calendar getAppointmentCalendar()
{
    Calendar cal = Calendar.getInstance();
    cal.setTime(this.appDate);
    return cal;
}