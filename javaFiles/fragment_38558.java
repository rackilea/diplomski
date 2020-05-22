class Goofy
{

   public static void main( String[] args )
   {
      final String input
              = "Home address H.NO- 12 SECTOR- 12 GAUTAM BUDH NAGAR " +
              "NOIDA- 121212, UTTAR PRADESH INDIA +911112121212 " +
              "Last Updated: 12-JUN-12 Semester/Term-time " +
              "Accommodation Type: Hall of residence (private " +
              "provider) Semester/Term-time address A121A SOME " +
              "APPARTMENT SOME LANE CITY COUNTY OX3 7FJ +91 " +
              "1212121212 Last Updated: 12-SEP-12 Mobile Telephone " +
              "Number : 01212121212";

      final String regex = "Home address (.+?) \\+\\d+ Last Updated: " +
              "\\S+ Semester/Term-time Accommodation Type: (.+?) " +
              "Semester/Term-time address (.+?) \\+\\d\\d \\d+ " +
              "Last Updated.+ Number : (\\d+)";

      Pattern pattern = Pattern.compile( regex );
      Matcher matcher = pattern.matcher( input );
      if( matcher.find() ) {
         System.out.println("Found: "+matcher.group() );
         for( int i = 1; i <= matcher.groupCount(); i++ ) {
            System.out.println( "   Match " + i + ": " + matcher.group( i ));
         }
      }
   }
}