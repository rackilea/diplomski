Calendar startCalendar = new GregorianCalendar();
startCalendar.setTime(startDate);
Calendar endCalendar = new GregorianCalendar();
endCalendar.setTime(endDate);

int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);