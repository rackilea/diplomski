Calendar scheduleStartTime = Calendar.getInstance();
scheduleStartTime.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
scheduleStartTime.set(Calendar.HOUR_OF_DAY, 11);
scheduleStartTime.add(Calendar.DAY_OF_YEAR, 7); // added this line to set next sunday
scheduleStartTime.set(Calendar.MINUTE, 0);
scheduleStartTime.set(Calendar.SECOND, 0);
scheduleStartTime.set(Calendar.MILLISECOND, 0);