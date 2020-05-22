Calendar startOfToday = Calendar.getInstance();
    Calendar endOfToday = Calendar.getInstance();
    endOfToday.setTime(startOfToday.getTime());

    startOfToday.set(Calendar.HOUR_OF_DAY, 0);
    startOfToday.set(Calendar.MINUTE, 0);
    startOfToday.set(Calendar.SECOND, 0);
    startOfToday.set(Calendar.MILLISECOND, 0);

    endOfToday.set(Calendar.HOUR_OF_DAY, 23);
    endOfToday.set(Calendar.MINUTE, 59);
    endOfToday.set(Calendar.SECOND, 59);
    endOfToday.set(Calendar.MILLISECOND, 999);

    long transactionDate = rc.getDate(1).getTime();
    if(transactionDate >= startOfToday.getTimeInMillis() && transactionDate <= endOfToday.getTimeInMillis()){

    }