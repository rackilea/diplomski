Calendar thatDay = Calendar.getInstance();
thatDay.set(Calendar.DAY_OF_MONTH,25);
thatDay.set(Calendar.MONTH,7); // 0-11 so 1 less
thatDay.set(Calendar.YEAR, 1985);

Calendar today = Calendar.getInstance();

long diff = today.getTimeInMillis() - thatDay.getTimeInMillis(); //result in millis

long days = diff / (24 * 60 * 60 * 1000);