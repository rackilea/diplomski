import lotus.domino.*;

Session session = NotesFactory.createSession((String)null, (String)null, password);

Database db = session.getDatabase(dominoServer, mailfile, false);

String strDateFormat;
// Get the date separator used on the Domino server, e.g. / or -
String dateSep = session.getInternational().getDateSep();

// Determine if the server date format is DMY, YMD, or MDY
if (session.getInternational().isDateDMY()) {
    strDateFormat = "dd" + dateSep + "MM" + dateSep + "yyyy";                
}
else if (session.getInternational().isDateYMD()) {
    strDateFormat = "yyyy" + dateSep + "MM" + dateSep + "dd";
}
else {
    strDateFormat = "MM" + dateSep + "dd" + dateSep + "yyyy";
}

DateFormat dateFormat = new SimpleDateFormat(strDateFormat);


String calendarQuery = "SELECT (@IsAvailable(CalendarDateTime) & (@Explode(CalendarDateTime) *= @Explode(@TextToTime(\"" +
    dateFormat.format(startDate) + " - " + dateFormat.format(endDate) + "\"))))";

DocumentCollection queryResults = db.search(calendarQuery);