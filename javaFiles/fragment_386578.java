private String getDateTimeToHexa() {
        Calendar mCalendar = Calendar.getInstance();
        TimeZone gmtTime =  TimeZone.getTimeZone(TimeZone.getDefault().getDisplayName());
        mCalendar.setTimeZone(gmtTime);
        final Date date = mCalendar.getTime();
        return Long.toHexString(date.getTime()/1000);
    }