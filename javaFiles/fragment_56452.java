DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
format.setLenient(false);               
for (CalendarEvent event : this.ListofEvents){
    // what does event.getDate() return?  A java.util.Date?  If yes, why are you doing this at all?
    String myDate = new String(event.getDate());
    try {
        theDate = format.parse(myDate);
        System.out.println(theDate.getDate());
    } catch (ParseException e) {
        e.printStackTrace();
    }
}