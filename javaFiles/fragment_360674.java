Calendar cal = Calendar.getInstance(); //current date and time      
cal.add(Calendar.DAY_OF_MONTH, 1); //add a day
cal.set(Calendar.HOUR_OF_DAY, 23); //set hour to last hour
cal.set(Calendar.MINUTE, 59); //set minutes to last minute
cal.set(Calendar.SECOND, 59); //set seconds to last second
cal.set(Calendar.MILLISECOND, 999); //set milliseconds to last millisecond
long millis = cal.getTimeInMillis();