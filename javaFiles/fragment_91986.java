Calendar presentDate = Calendar.getInstance();

    Calendar startDate = Calendar.getInstance();
    startDate.set(Calendar.HOUR_OF_DAY, 8);
    startDate.set(Calendar.MINUTE, 30);
    startDate.set(Calendar.SECOND, 0);

    Calendar endDate = Calendar.getInstance();
    endDate.set(Calendar.HOUR_OF_DAY, 15);
    endDate.set(Calendar.MINUTE, 0);
    endDate.set(Calendar.SECOND, 0);

    if (presentDate.after(startDate) && presentDate.before(endDate)) {
        // set morning here
    } else {
        // set your data here
    }