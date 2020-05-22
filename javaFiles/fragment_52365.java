Calendar timeLessCalendar = Calendar.getInstance()
timeLessCalendar.set(Calendar.HOUR_OF_DAY,0);
timeLessCalendar.set(Calendar.MINUTE,0);
timeLessCalendar.set(Calendar.SECOND,0);
timeLessCalendar.set(Calendar.MILLISECOND,0);
//now grab the seconds
long secondTillDate =  timeLessCalendar.getTime().getTime()/1000;