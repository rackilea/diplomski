import java.util.Scanner;

class learn {
   public static void main (String args[]) {
   // Handling user input is difficult, for Java you will need to know
   // about Strings, integers, maybe floating point, maybe dates...
   // If the use is directly typing something we will be getting characters,
   // and Java generally handles characters with a String.
   // What you do with the characters your user typed can be challenging...
   // How would you let your user type in....
   //     an age?
   //     an amount of money?  (does currency matter?  yuan? yen? dollars? pounds? )
   //     a fraction?  1/5,  1/3, etc?
   //     text? (like a name) ?
   //     a date?  January 1, 2017
   // I suppose we should start with the basics. :-)
   // All user input from the keyboard will come in as characters.
   // "Scanner" tries to help you by changing those characters into 
   // other Java types.  Until you actually Know those types
   // prett well, I suggest it will be better for you to work direclty
    // with the characters.
   // Then Scanner will be a fine tool and you will understand what it
   // is doing on your behalf.

   System.out.println("Hello Malcolm! Mommy loves you^_^. How old are you  :");
   // we're going to move age & months down below.
   // OLD: int age;
   // OLD: int months;
   // Style-wise, as others have pointed out, "Scanner" isn't really a number.
   // So let's change that to just "s" (short for Scanner).
   // OLD: Scanner number = new Scanner(System.in);
   // OLD: age = number;
   Scanner s = new Scanner(System.in);
   String input = s.nextLine(); // ask our scanner for all the characters our user typed.
   // (there are other ways we could get input from our user,
   // but we'll stick with Scanner.)


   // At this point, whatever our user typed is in the "input" String variable.
   // Never hesitate to add plenty of prints to show what is going on.
   // This helps a lot with debugging and research, you can comment them out
   // when it is working the way you want.
   System.out.println("input=\""+input+"\""); // for debugging, to help you see what is happening.
   System.out.println("input has "+input.length()+" characters."); // for debugging


   // A major part of handling user intput is validation.
   // We have to make sure they typed what we are looking for.
   // What happens if they just hit enter?
   // What happens if they typed a random word, like "BLUE", instead of an age?
   // What happens if they typed a random word instead of an age?
   // How do we tell if they actually typed in an age?
   // It looks like you want age to be "YEARS.MONTHS"
   // Ok... that is going to be very confusing to people that use periods for decimal separators,
   // like 3.14159  but what the heck - this is just a learning exercise.

   // So let's add some validation checks.
   // There are other friendlier ways you could handle problems with the input.
   // If you have studied looping, think about asking the user for a line of input
   // until we get a String we can use as an age.
   // System.exit() is kind of harsh, but just think of it as a stepping stone.
   if( input.length() == 0 ) {
      System.err.println("expected 1 or more characters, please try again.");
      System.exit(0);
   }

   int periodLocation = input.indexOf( '.' ); // see if we have a period
   System.out.println("periodLocation="+periodLocation);
   // Question: how would you change this to make "months" optional?
   if( periodLocation == -1 ) {
      System.err.println("expected a perid between AGE and MONTHS, please try again.");
      System.exit(0);
   }

   String agePart = input.substring( 0, periodLocation );  // grab everything before the period
   System.out.println("agePart=\""+agePart+"\""); // for debugging

   String monthsPart = input.substring( periodLocation+1 );  // grab everything after the perid
   System.out.println("monthsPart=\""+monthsPart+"\""); // for debugging

   int age = Integer.parseInt(agePart);
   int months = Integer.parseInt(monthsPart);

   // If we were being thorough...
   // a) We might check to make sure we have positive numbers.
   // (What happens if our user types in "-1.-2" ? )
   // b) We would check to make sure we had only digit characters
   // with a single period inside of them.
   // c) What would happen if the users entered more than 12 months, like "0.100"?
   // Would that case problems?
   //
   // The take home lesson here is there are MANY ways for users to give you
   // incorrect input. :-)
   // Anyway, lets see if we have some Java integers now...

   System.out.println("age="+age+", months="+months); // for debugging


   // Good, looks like the integer extract stuff works.
   // Next you want to work with the "3 months" part,
   // which is fractional years, e.g. 0 years and 3 months is 0.25 years.
   // As others have pointed out, switches like integers.
   // So we *could* do a trick like this and talk in terms of months, not years...

   int totalMonths = age*12 + months;
   System.out.println( "totalMonths="+totalMonths );

    //OLD: switch (age)
   System.out.println("=== switch-style ===");
   switch ( totalMonths ) {
          //OLD: case 0: 
          case 0: 
             System.out.println("You were born Feb 12 2016 and when you cry you look like an old man");
             break;
          //OLD: case .3:
          case 3:
             System.out.println("You are 3 months!!! You can smile real big     at mommy and daddy");
             break;
          //OLD: case 1:
          case 1*12:
          System.out.println("You will walk");
             break;
          //OLD: case 2:
          case 2*12:
             System.out.println("You will talk");
             break;
          //OLD: case 3
          case 3*12:
             // note about 1*12, 2*12, 3*12: you could do the math and use 36 here instead of
             // letting the java compiler handle it, but I think 3*12 is more clear for "intent"
             // than just 36.
             System.out.println("You will run and play");
             break;
          default:
          System.out.println("I don't know how old you are. You must be and old man^-^");
             break;
             // kind of a do-nothing break since this is last item in our switch(), but harmless.
       }

       // Let's compare the switch{...}  approach to if/else logic.
       // one way to do it is like this...
       // I'll let you decide which approach feels better... much of the "art" of
       // programming is about aesthetics and feel.  People call that "elegance", or
       // lack thereof. :-)  But seriously, it will help you to think of ways to make
       // your code elegant.  And when you're reviewing answers on StackOverflow, check
       // to see which ones get more votes - they tend to be more elegant.
       System.out.println("=== if-style ===");
       if( age == 0 ) {
          if( months == 0 ) {
             System.out.println("You were born Feb 12 2016 and when you cry you look like an old man");
          } else if( months == 3 ) {
             System.out.println("You are 3 months!!! You can smile real big     at mommy and daddy");
          }
       } else if ( age == 1 ) {
          System.out.println("You will walk");
       } else if ( age == 2 ) {
             System.out.println("You will talk");
       } else if ( age == 3 ) {
             System.out.println("You will run and play");
       } else {
          System.out.println("I don't know how old you are. You must be and old man^-^");
       }
    }
    // That is all I have for you.
    // So, welcome to programming and I hope you have fun learning Java. :-)
    // (p.s. after you learn Java, don't stop - there are more elegant languages out there).
}