Calendar cal1 = Calendar.getInstance();
Calendar cal2 = Calendar.getInstance();
cal1.setTime(date1);
cal2.setTime(date2);
boolean sameDay = cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR) &&
                  cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);