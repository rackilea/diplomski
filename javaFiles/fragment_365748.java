public class InputTest
{

   public static void main( String[] args )
   {
      Scanner scan = new Scanner( System.in );
      int input = 0;
      do {
         System.out.print( "Choose a function (-1 to exit): " );
         input = scan.nextInt();
         switch( input ) {
            case 1:
               System.out.println("..1");
               break;
            case 2:
               System.out.println("..2");
               //same while loop here
               String line = scan.nextLine();
               System.out.println(">>"+line+"<<");
               while( line.length() > 0 ) {
                  System.out.println( "  Read line: " + line );
                  line = scan.nextLine();
                  System.out.println(">>"+line+"<<");
               }
               break;
         }
      } while( input != -1 );
   }
}