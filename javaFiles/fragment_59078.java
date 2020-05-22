public static class DateThatAddsYear extends Date {
 public DateThatAddsYear( String time ) {
  super( time );
  Calendar cal = GregorianCalendar.getInstance();
  cal.setTime( this );
  // Jump back to 2010, this needs to be implemented more thoroughly in order 
  // to support dates crossing calendar year boundaries
  cal.set( Calendar.YEAR, 2010 );
  setTime( cal.getTimeInMillis() );
 }
}