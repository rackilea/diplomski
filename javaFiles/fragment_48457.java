Calendar cal1 = Calendar.getInstance();
    cal1.set(Calendar.HOUR_OF_DAY, 10); // use hour of day for am pm issue
    cal1.set(Calendar.MINUTE, 00);
    cal1.set(Calendar.SECOND, 00);

    Calendar now = Calendar.getInstance();
        if (now.after(cal1))
            cal1.add(Calendar.DAY_OF_YEAR, 1);
// this code snippet add one day if the current time passed away 
//else use cal1.set(year, month, day); for exact day