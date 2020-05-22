public static void checkDate(String date) throws ParseException {
    Calendar calendar = Calendar.getInstance();
    int year = Integer.parseInt(date.substring(0, 2));
    int month = Integer.parseInt(date.substring(2, 4));
    calendar.setLenient(false);         
    int yearOfCentury = calendar.get(Calendar.YEAR);
    int century = yearOfCentury - yearOfCentury % 100;
    year = year + century;
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month-1);
    calendar.set(Calendar.DATE,             calendar.getActualMaximum(Calendar.DATE));
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE,  59);
    calendar.set(Calendar.SECOND,  59);
    System.out.println("Date +" + calendar.getTime());    
}