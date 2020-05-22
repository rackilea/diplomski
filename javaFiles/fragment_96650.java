Calendar firstCalendar = Calendar.getInstance();
firstCalendar.setTime(firstDate); //set the time as the first java.util.Date

Calendar secondCalendar = Calender.getInstance();
secondCalendar.setTime(secondDate); //set the time as the second java.util.Date

int year = Calendar.YEAR;
int month = Calendar.MONTH;
int difference = secondCalendar.get(year) - firstCalendar.get(year);
if (difference > 0 && 
    (secondCalendar.get(month) < firstCalendar.get(month))) {
    difference--;
}