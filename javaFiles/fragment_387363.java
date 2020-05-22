public static void main(String[] args) {
    final Calendar c = Calendar.getInstance();

    //set the timestamp info to 00:00:00 so that we can compare the dates later if needed
    c.set(Calendar.HOUR_OF_DAY, 0);
    c.set(Calendar.MINUTE, 0);
    c.set(Calendar.SECOND, 0);
    c.set(Calendar.MILLISECOND, 0);

    final int days = 61; //61 because we will add the result after we add the day

    final List<Date> datesList= new ArrayList<Date>(); //list to store each date object

    for (int i = 0; i < days; i++) {
        c.add(Calendar.DATE, 1); //add one day to the calendar (so first value is tomorrow)
        datesList.add(new Date(c.getTimeInMillis())); //store each day in the list
    }

    //iterate through the list and do whatever you want with the dates
    for (Date date : datesList) {
        System.out.println(date);
    }
}