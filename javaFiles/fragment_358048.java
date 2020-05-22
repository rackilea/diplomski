try {
    String string1 = "20:11:13";
    Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
    Calendar calendar1 = Calendar.getInstance();
    calendar1.setTime(time1);
    calendar1.add(Calendar.DATE, 1);


    String string2 = "14:49:00";
    Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
    Calendar calendar2 = Calendar.getInstance();
    calendar2.setTime(time2);
    calendar2.add(Calendar.DATE, 1);

    String someRandomTime = "01:00:00";
    Date d = new SimpleDateFormat("HH:mm:ss").parse(someRandomTime);
    Calendar calendar3 = Calendar.getInstance();
    calendar3.setTime(d);
    calendar3.add(Calendar.DATE, 1);

    Date x = calendar3.getTime();
    if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
        //checkes whether the current time is between 14:49:00 and 20:11:13.
        System.out.println(true);
    }
} catch (ParseException e) {
    e.printStackTrace();
}