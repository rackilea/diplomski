public class Main
{
  public static void main( String[] args )
  {
    Scanner sc = new Scanner( System.in );
    System.out.println( "Enter A,B or C" );
    String rawInput = sc.nextLine();
    String trimmedInput = rawInput.trim();
    if ( trimmedInput.length() > 0 )
    {
      // switching our String
      switchInputValue( trimmedInput );
    }
  }

  private static void switchInputValue( String value )
  {
    switch ( value )
    {

      case "a":
      case "A":
        doSomethingForA();
        break;

      case "b":
      case "B":
        doSomethingForB();
        break;
      default:
        doSomethingIfEverythingElseFails();
        break;
    }
  }
}