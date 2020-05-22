long startDate;
long endDate;

private void calculateMonthStartAndEndTime(int month, int year){
//create the first date of month
Calendar mycal = new GregorianCalendar(year,month, 1);
startDate = mycal.getTimeInMillis();

// Get the number of days in that month which actually gives the last date.
int lastDate = mycal.getActualMaximum(Calendar.DAY_OF_MONTH);
mycal = new GregorianCalendar(year, month, lastDate);
endDate = mycal.getTimeInMillis();
}