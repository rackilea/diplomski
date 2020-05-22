Calendar cal = Calendar.getInstance();
cal.clear();
cal.set(Calendar.YEAR, 2014);
cal.set(Calendar.MONTH, Calendar.MAY);
cal.set(Calendar.DATE, 09);
cal.set(Calendar.HOUR_OF_DAY, 9);
Date startDate = cal.getTime();

//Use JodaTime to calculate difference
Period period =  getTimePassedSince(startDate);

//Extract values and display
long days= Math.abs(period.getDays()));
long hours= Math.abs(period.getHours()));
long minitues =Math.abs(period.getMinutes()));
long secnds =Math.abs(period.getSeconds()));

...
public static Period getTimePassedSince(Date initialTimestamp){
        DateTime initDT = new DateTime(initialTimestamp.getTime());
        DateTime now = new DateTime();
        Period p = new Period(initDT, now, PeriodType.dayTime()).normalizedStandard( PeriodType.dayTime());
        return p;
    }