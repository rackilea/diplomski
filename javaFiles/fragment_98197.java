final DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyyMMdd");

LocalDate date=null;
while( (line = getNextLine())!=null) {
   String dateAsString = line.split(delims)[0];
   LocalDate founddate = dtf.parseLocalDate(dateAsString);
   if(date==null) { date= founddate; continue;} // first
   if(founddate.before(date)) throw new RuntimeException("date not sorted?");
   if(founddate.equals(date)) continue; // dup dates are ok?
   date = date.plusDays(1);
   while(date.before(foundate)){
       System.out.println("Date not found: " +date);
       date = date.plusDays(1);
   }
}