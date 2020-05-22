GregorianCalendar gc = new GregorianCalendar();
gc.setTime(date);
gc.set(Calendar.HOUR_OF_DAY, 0);
gc.set(Calendar.MINUTE, 0);
gc.set(Calendar.SECOND, 0);
gc.set(Calendar.MILLISECOND, 0);
Date returnDate = gc.getTime();