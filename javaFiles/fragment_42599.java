int day = Calendar.Sunday; 
int startDayOfWeek = startDate.getCalendar().get(Calendar.DAY_OF_WEEK);
int endDayOfWeek = endDate.getCalendar().get(Calendar.DAY_OF_WEEK); 

if(startDayOfWeek < day && endDayOfWeek > day) {
     //The given day is between the start and end days.
}