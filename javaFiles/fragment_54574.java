DateTime now = DateTime.now();

DateTime start1 = now;
DateTime end1 = now.plusMinutes(1);

DateTime start2 = now.plusSeconds(50);
DateTime end2 = now.plusMinutes(2);

Interval interval = new Interval( start1, end1 );
Interval interval2 = new Interval( start2, end2 );

System.out.println( interval.overlaps( interval2 ) );