public class Driver {
   public static void main(String args[]) {
     boolean keepGoing = true;
     do {
       //collect shape information 
       System.out.println("Enter your shape (1 = triangle ...");
       shape = stdIn.nextInt();

       // based upon the shape, collect the inputs
       double inp1, inp2;
       switch (shape) {
         case 1:
           // inp1 is the base, inp2 is the height
           System.out.println("Enter Base: ");
           inp1 = stdIn.nextDouble();
           System.out.println("Enter Height: ");
           inp2 = stdIn.nextDouble();
         break;
       }  //switch shape

       // create a shape area instance; this calculates the
       //   area and outputs the answer  
       Shape_Area sa = new Shape_Area(shape, inp2, inp2);

       // prompt the user to enter another shape
       if (user_wants_to_stop) {
         keepGoing = false;
       }
     } while (keepGoing)
   } // main()
}