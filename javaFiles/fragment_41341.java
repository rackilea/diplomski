Calendar calToday = Calendar.getInstance();
    calToday.set(Calendar.YEAR, calToday.get(Calendar.YEAR));
    calToday.set(Calendar.MONTH, calToday.get(Calendar.MONTH));
    calToday.set(Calendar.DATE, calToday.get(Calendar.DATE));
    calToday.set(Calendar.HOUR_OF_DAY, 0);
    calToday.set(Calendar.MINUTE, 0);
    calToday.set(Calendar.SECOND, 0);
    calToday.set(Calendar.MILLISECOND, 0); // this is important
    long now = calToday.getTimeInMillis();
    long DiffDays = (sqlDate - now) / (24 * 60 * 60 * 1000);
    Log.e("-->", ""+sqlDate );
    Log.e("-->", ""+now);
    Log.e("-->", ""+(sqlDate - now));
    Log.e("-->", ""+DiffDays);
    Log.e("-->", "====================");