Calendar cal = new GregorianCalendar();
cal.set( Calendar.HOUR_OF_DAY, 9 );
cal.set( Calendar.MINUTE, 17 );

cal.add( Calendar.HOUR_OF_DAY, -5 );
System.out.println( cal.getTime() );