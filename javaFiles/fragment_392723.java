Calendar before = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
before.set(Calendar.DST_OFFSET, 3600000);       
before.set(Calendar.DAY_OF_MONTH, 25);
before.set(Calendar.MONTH, Calendar.OCTOBER);
before.set(Calendar.HOUR_OF_DAY, 2);
before.set(Calendar.MINUTE, 30);
before.set(Calendar.SECOND, 0);
before.set(Calendar.MILLISECOND, 0);

System.out.println("BEFORE DST CHANGE: " + before.getTime());       

Calendar after = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"));
after.set(Calendar.DAY_OF_MONTH, 25);
after.set(Calendar.MONTH, Calendar.OCTOBER);
after.set(Calendar.HOUR_OF_DAY, 2);
after.set(Calendar.MINUTE, 30);
after.set(Calendar.SECOND, 0);
after.set(Calendar.MILLISECOND, 0);

System.out.println("AFTER DST CHANGE: " + after.getTime());

System.out.println("before.compareTo(after): " + before.compareTo(after));