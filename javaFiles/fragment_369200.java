public class InputCleaner
{
    private final static List<String> allowedEntries = Arrays.asList( new String[] { "FF", "SF", "FB", "SB", "Pause" } );

    public static void main( String[] args ) throws Exception
    {
        String input = "FF,SF,FB,SB,FF,Pause";
        String input2 = "FF,SF,FB,SB,FfdsG,FF,Pause";

        validateInput( input );
        validateInput( input2 );
    }

    private static void validateInput( String input ) throws Exception
    {
        for (String value : input.split( "," ))
        {    
            if( !allowedEntries.contains( value ) )
            {
                throw new Exception( "Found a bad input value! " + value );
            }
        }

        System.out.println( "Input string clean:" + input );
    }
}