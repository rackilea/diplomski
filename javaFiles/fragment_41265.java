public class SimpleIsland
{
    public boolean getTrue()
    {
        return true;
    }
    public boolean getFalse()
    {
        return false;
    }
    public static void myProgram()
    {
        if ( false || true )
        {
            if ( false )
            {
                if ( true )
                {
                    System.out.println( "if if if" );
                }
                else 
                {
                    System.out.println( "if if else" );
                }
            }
            else 
            {
                if ( true )
                {
                    System.out.println( "if else if" );
                }
                else 
                {
                    System.out.println( "if else else" );
                }
            }
        else
        {
            System.out.println( "else" );
        }
    }
}