String time = "20:30:44 PM"; // this is your input string
SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss aa");

try {
    Date date = sdf.parse(time);

    // this is the uglier solution
    System.out.println("The hour is: "+date.getHours());

    GregorianCalendar gc = new GregorianCalendar();
    gc.setTime(date);

    // this is nicer solution
    System.out.println("The hour is: "+gc.get(Calendar.HOUR_OF_DAY));

} catch (ParseException e) {
    System.err.println("Couldn't parse string! "+e.getMessage());
}