//Get epoch value
MutableDateTime epoch = new MutableDateTime(0l, DateTimeZone.UTC);

DateTime currentDate = new DateTime(); //Can take Java Date in constructor
Days days = Days.daysBetween(epoch, currentDate);

//We can write number of days since epoch into the record
record.put("myDate", days.getDays());