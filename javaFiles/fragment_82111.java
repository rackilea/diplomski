Calendar start = Calendar.getInstance();
Calendar end = Calendar.getInstance();
start.set(2010, 7, 23);
end.set(2010, 8, 26);
Date startDate = start.getTime();
Date endDate = end.getTime();
long startTime = startDate.getTime();
long endTime = endDate.getTime();
long diffTime = endTime - startTime;
long diffDays = diffTime / (1000 * 60 * 60 * 24);
DateFormat dateFormat = DateFormat.getDateInstance();
System.out.println("The difference between "+
  dateFormat.format(startDate)+" and "+
  dateFormat.format(endDate)+" is "+
  diffDays+" days.");