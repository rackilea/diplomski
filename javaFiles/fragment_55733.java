import java.util.Scanner;
// NEW: see nested switches, below.
class Learn2 {
   public static void main (String args[]) {
      System.out.println("Hello Malcolm! Mommy loves you^_^. How old are you  :");
      Scanner s = new Scanner(System.in);
      String input = s.nextLine();
      System.out.println("input=\""+input+"\"");
      System.out.println("input has "+input.length()+" characters.");

      if( input.length() == 0 ) {
         System.err.println("expected 1 or more characters, please try again.");
         System.exit(0);
      }

      int periodLocation = input.indexOf( '.' ); // see if we have a period
      System.out.println("periodLocation="+periodLocation);
      if( periodLocation == -1 ) {
         System.err.println("expected a perid between AGE and MONTHS, please try again.");
         System.exit(0);
      }

      String agePart = input.substring( 0, periodLocation );  // grab everything before the period
      System.out.println("agePart=\""+agePart+"\"");
      String monthsPart = input.substring( periodLocation+1 );  // grab everything after the perid
      System.out.println("monthsPart=\""+monthsPart+"\"");

      int age = Integer.parseInt(agePart);
      int months = Integer.parseInt(monthsPart);
      System.out.println("age="+age+", months="+months);

      switch ( age ) {
         case 0:
            // NEW: a nested switch() { } might be an easier
            // way to handle months than jamming everything
            // into totlaMonths.
            switch( months ) {
               case 0:
                  System.out.println("You were born Feb 12 2016 and when you cry you look like an old man");
                  break;
               case 3:
                  System.out.println("You are 3 months!!! You can smile real big     at mommy and daddy");
                  break;
               default:
                  System.out.println("hit default on switch for months, age="+age+" months="+months );
            } // END for switch( months )
            break; // remember this applies to switch(age), we're no longer in switch(months) at this point.
         case 1:
            System.out.println("You will walk");
            break;
         case 2:
            System.out.println("You will talk");
            break;
         case 3:
            System.out.println("You will run and play");
            break;
         default:
            System.out.println("I don't know how old you are. You must be and old man^-^   (age="+age+", months="+months+")");
            // break; // after case (or default) break doesn't matter.
      }
   }
}