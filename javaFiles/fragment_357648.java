public static void main(String[] args) {        

   //From the given date
    Calendar startDate = Calendar.getInstance(Locale.US);
    startDate.set(2015, Calendar.JANUARY, 30);
    printNWeeks(startDate, 5);

    //From Current Date     
    startDate = Calendar.getInstance(Locale.US);
    printNWeeks(startDate, 5);
}