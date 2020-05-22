Calendar updateTime = Calendar.getInstance(TimeZone.getTimeZone("Asia/Calcutta"));
updateTime.set(Calendar.HOUR_OF_DAY, 0); // set hour
updateTime.set(Calendar.MINUTE, 0); // set minute
updateTime.set(Calendar.SECOND, 0); // set seconds
updateTime.set(Calendar.MILLISECOND, 0); // set milliseconds

long time = updateTime.getTimeInMillis(); // get milliseconds
System.out.println(updateTime.getTime());
System.out.println(time);