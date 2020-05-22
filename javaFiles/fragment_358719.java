public class Main
{
  public static void main( String[] args )
  {
    Scanner sc = new Scanner( System.in );

    System.out.println( "Enter A,B or C" );

    // read from console
    String rawInput = sc.nextLine();
    // remove unneccessary whitespaces.
    String trimmedInput = rawInput.trim();
    // assure that our string was not only containing whitespaces.
    if ( trimmedInput.length() > 0 )
    {
      // assign the value
      char value = trimmedInput.charAt( 0 );
      switchInputValue( value );
    }
  }

  private static void switchInputValue( char value )
  {
    switch ( value )
    {

      case 'a':
      case 'A':
        doSomethingForA();
        break;

      case 'b':
      case 'B':
        doSomethingForB();
        break;
      default:
        // get creative here
        // example:
        System.out.println("Something went wrong. - Wong input value.");
        break;

    }
  }
}