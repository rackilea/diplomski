class Prova
{

   public static void main( String[] args )
   {

//      SimpleDateFormat dateFormat = new SimpleDateFormat( 
//              "dd/MM/yyyy z" );
      SimpleDateFormat dateFormat = new SimpleDateFormat( 
              "dd/MM/yyyy" );
      String dep = "13/11/2014 GMT+12:00";
      GregorianCalendar gc1 = new GregorianCalendar();

      try {

         String[] dateZone = dep.split( " " );
         Date date = dateFormat.parse( dateZone[0] );
         TimeZone tz = TimeZone.getTimeZone( dateZone[1] );
         gc1.setTimeZone(tz);
         gc1.setTime(date);

//         gc1.setTime( dateFormat.parse( dep ) );
         System.out.println( dateFormat.format( gc1.getTime() ) +
                 " time zone: " + gc1.getTimeZone().getID() );

      } catch( ParseException e ) {
         e.printStackTrace();
      }

   }
}