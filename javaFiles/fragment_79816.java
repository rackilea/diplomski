import java.util.Scanner;

public class PinChecker {

   // Immutable Class
   private static final class Pin {

      private String _pin;

      Pin(String pin) {
         this._pin = pin;
      }

      public String toString() {
         return _pin;
      }

      public boolean equals(Pin pin) {
         if(pin.toString().equals(_pin)) {
            return(true);
         } else {
            return(false);
         }
      }

   }

   public static final int NB_OF_TRIES = 3;

   public static void main(String[] args) {

      System.out.println("Enter your PIN :");
      Pin userPin = new Pin("FOO");

      Scanner console = new Scanner(System.in);

      boolean pinMatch = false;
      int i = 0;

      while(!pinMatch && i < NB_OF_TRIES) {

         Pin keyedPin = new Pin(console.nextLine());
         i++;

         if(userPin.equals(keyedPin)) {
            pinMatch = true;
         } else {
            System.out.println("Invalid PIN!");
         }
      }

      if(pinMatch) {
         System.out.println("OK, nb of tries :" + i);
      } else {
         System.out.println("KO, nb of tries :" + i);
      }

   }

}