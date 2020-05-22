DateTime currentdate1 = DateTime.now(); //first Date range
DateTime endDate1 = now.plusHours(10);

DateTime currentdate2 = now.plusDays(5); //second Date range
DateTime endDate2 = now.plusDays(6);

Interval interval1 = new Interval( currentdate1, endDate1  );
Interval interval2 = new Interval( currentdate2, endDate2  );

System.out.println( interval1.overlaps( interval2 ) );