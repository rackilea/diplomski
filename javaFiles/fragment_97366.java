Timestamp _before = (Timestamp) MySQLString.getTime();
Timestamp _now = new Timestamp(new DateTime().getMillis());
System.out.println("CONVERT RESULT MINUTES: "+minutesBetweenTimestamps(_before, _now));

//Pass the variables to this method 

public Integer minutesBetweenTimestamps(Timestamp before, Timestamp after){
    long _timeGap = after.getTime() - before.getTime();
    return (int) (_timeGap / 1000 / 60);
}