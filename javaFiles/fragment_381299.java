Calendar cal = Calendar.getInstance();
cal.setTime(dateYouWantToTruncate);
cal.clear(Calendar.HOUR);
cal.clear(Calendar.MINUTE);
cal.clear(Calendar.SECOND);
cal.clear(Calendar.MILLISECOND);
Date dateOnly = cal.getTime();