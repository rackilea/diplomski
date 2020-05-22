interface RunIt < E extends Exception >
{
    void run ( ) throws E ;
}

class App
{
    public static void main ( String [ ] args )
    {
        RunIt < RuntimeException > r = new RunIt < RuntimeException > ( )
        {
            public void run ( )
            {
                throw new RuntimeException ( ) ;
            }
        } ;
        r . run ( ) ;
    }
}