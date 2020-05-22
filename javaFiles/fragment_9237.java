Calendar calendar = Calendar.getInstance();
calendar.setTime(date);
calendar.set(Calendar.HOUR_OF_DAY, 0); // <-- here
calendar.set(Calendar.MINUTE, 0);
calendar.set(Calendar.SECOND, 0);
calendar.clear(Calendar.MILLISECOND);