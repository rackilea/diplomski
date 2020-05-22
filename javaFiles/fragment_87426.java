Calendar cal = Calendar.getInstance(); // represents right now, i.e. today's date
cal.set(Calendar.HOUR_OF_DAY, 23);
cal.set(Calendar.MINUTE, 59);
cal.set(Calendar.SECOND, 59);
cal.set(Calendar.MILLISECOND, 999); // credit to f1sh

Date date = cal.getTime();