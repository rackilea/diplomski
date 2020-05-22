GregorianCalendar gc=new GregorianCalendar();
gc.set(GregorianCalendar.YEAR, 2012);
gc.set(GregorianCalendar.DAY_OF_YEAR, 32);
System.out.println(gc.getTimeInMillis()/1000/60); // /1000 -> in seconds; /60-> in minutes

System.out.println(gc.get(GregorianCalendar.DATE));
System.out.println(gc.get(GregorianCalendar.MONTH));//months are indexed from 0
System.out.println(gc.get(GregorianCalendar.YEAR));