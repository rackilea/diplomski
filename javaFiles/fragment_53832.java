Calendar mondayFirst = Calendar.getInstance(Locale.GERMANY); //Locale that has Monday as first day of week
mondayFirst.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
log(DateUtils.formatDateTime(context, mondayFirst.getTimeInMillis(), 0));
//prints "May 19" when runned on May 13

Calendar sundayFirst = Calendar.getInstance(Locale.US); //Locale that has Sunday as first day of week
sundayFirst.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
log(DateUtils.formatDateTime(context, sundayFirst.getTimeInMillis(), 0));
//prints "May 12" when runned on May 13