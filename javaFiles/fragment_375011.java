public static Date createDateInstance(int month, int year, int date){
  Calendar cal= Calendar.getInstance();
  cal.set(Calendar.YEAR, year);
  cal.set(Calendar.MONTH, month);
  cal.set(Calendar.DATE, date);

  return cal.getTime();

}