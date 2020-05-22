LocalDate date=null;
int cont=0;
while( (line = getNextLine())!=null) {
   String dateAsString = line.split(delims)[0];
   LocalDate founddate = dtf.parseLocalDate(dateAsString);
   if(date==null) { date= founddate; continue;} // first
   if(founddate.before(date)) throw new RuntimeException("date not sorted?");
   if(founddate.equals(date)) continue; // dup dates are ok?
   cont += Days.daysBetween(date, founddate)-1;
   date = founddate;
}