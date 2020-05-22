public void setOverdueFlagIfRequired(Date today, Date causedAtDate) {       
    Calendar now = Calendar.getInstance();
    now.setTime(today);

    Calendar causedAt = Calendar.getInstance();
    causedAt.setTime(causedAtDate);

    Calendar yesterday2300 = Calendar.getInstance();
    yesterday2300.setTime(today);
    yesterday2300.add(Calendar.DATE, -1);
    yesterday2300.set(Calendar.HOUR_OF_DAY, 23);
    yesterday2300.set(Calendar.MINUTE, 0);
    yesterday2300.set(Calendar.SECOND, 0);
    yesterday2300.set(Calendar.MILLISECOND, 0);

    Calendar fiveDaysBack2300 = Calendar.getInstance();
    fiveDaysBack2300.setTime(yesterday2300.getTime());      
    fiveDaysBack2300.add(Calendar.DATE, -4);

    if (causedAt.compareTo(fiveDaysBack2300)<=0) {
        setFiveDaysOverdue(true);
    }
    else if (causedAt.compareTo(yesterday2300)<=0 && causedAt.compareTo(fiveDaysBack2300)>0) {
        setOneDayOverdue(true);
    }
}