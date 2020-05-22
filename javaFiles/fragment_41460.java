LocalDate date1 = new LocalDate("2011-12-12");
 LocalDate date2 = new LocalDate("2012-11-11"); 
 while(date1.isBefore(date2)){
     System.out.println(date1.toString("MMM/yyyy"));
     date1 = date1.plus(Period.months(1));
 }