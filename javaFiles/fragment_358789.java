final Calendar first = new Calendar.Builder()
        .setDate(2016, 2, 1).set(Calendar.AM_PM, 0).set(Calendar.HOUR, 8).build();
final Calendar second = Calendar.getInstance();

int numberOfDays = 0;
long numberOfHours = 0;
//Get number of full days
while(first.get(Calendar.DATE) != second.get(Calendar.DATE)){
    if(Calendar.SATURDAY != first.get(Calendar.DAY_OF_WEEK)
            && Calendar.SUNDAY != first.get(Calendar.DAY_OF_WEEK)){
        numberOfDays++;
    }
    first.roll(Calendar.DATE, true);
}
//Get number of hours in the remaining day
numberOfHours = TimeUnit.MILLISECONDS
        .toHours(second.getTimeInMillis() - first.getTimeInMillis());

System.out.println("Difference = " + 
        ( numberOfDays * 24 + numberOfHours ) + " hour(s)");