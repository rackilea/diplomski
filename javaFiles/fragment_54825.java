long WEEK_IN_MILLIS = 7 * 24 * 60 * 60 * 1000;
List<Date> dates = ...
Collections.sort(dates);
int weekNumber = 1;
int counter = 0;
Date weekStart = null;
for(Date date : dates) {        
    if (weekStart == null) {
        weekStart = date;          
    }
    else {
        long interval = date.getTime() - weekStart.getTime();
        if (interval > WEEK_IN_MILLIS) {
            System.out.printf("Week %s has %s dates in it", weekNumber, counter);
            weekNumber++;
            weekStart = date;
            counter = 0;
        }
    }
    counter++;
}