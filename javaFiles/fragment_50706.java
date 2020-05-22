for(Date date:randomDates){
//check if the date in in the range
if( (DateRangeStart.compareTo(date)<=0) && (date.compareTo(DateRangeEnd)<=0)){
//date overlaps
System.out.println(dateFormat.format(date));
}
}