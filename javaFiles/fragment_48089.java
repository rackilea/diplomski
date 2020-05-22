public static String extractDigits(final String in) {
   final Pattern p = Pattern.compile( "(\\d{6})" );
   final Matcher m = p.matcher( in );
   if ( m.find() ) {
     return m.group( 0 );
   }
   return "";
 }