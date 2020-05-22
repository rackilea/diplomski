Calendar mergedCal = Calendar.getInstance();
mergedCal.setTime(date);
Calendar sqlCal = Calendar.getInstance();
sqlCal.setTime(time.getTime());
mergedCal.set(Calendar.HOUR_OF_DAY, sqlCal.get(Calendar.HOUR_OF_DAY));
mergedCal.set(Calendar.MINUTE, sqlCal.get(Calendar.MINUTE));
mergedCal.set(Calendar.SECOND, sqlCal.get(Calendar.SECOND));
mergedCal.getTime();