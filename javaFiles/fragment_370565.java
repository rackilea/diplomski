public static void main(String[] args) throws Exception {
      // 97.560883
      System.out.println(formatNum(Double.parseDouble("9.756088256835938E+1")));
      // 9.756E+11
      System.out.println(formatNum(Double.parseDouble("9.756088256835938E+11"))); 
      // 0.0009756
      System.out.println(formatNum(Double.parseDouble("9.756088256835938E-4")));  
      // -9.8E+111
      System.out.println(formatNum(Double.parseDouble("-9.756088256835938E+111")));
   }

   private static final int MAX_LENGTH = 9;

   private static String formatNum(double number) {
      String out = null;
      for ( int i = 0; i < MAX_LENGTH; i++ ) {
         String format = "%." + i + "G";
         out = String.format(format, number);
         if ( out.length() == MAX_LENGTH ) {
            return out;
         }
      }
      return out; //the best we can do
   }