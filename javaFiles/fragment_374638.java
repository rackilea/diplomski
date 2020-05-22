try
{
     method . invoke ( args ) ;
}
catch ( IllegalArgumentException cause )
{
     // reflection exception
}
catch ( NullPointerException cause )
{
     // reflection exception
}
catch ( InvocationTargetException cause )
{
     try
     {
           throw cause . getCause ( ) ;
     }
     catch ( IllegalArgumentException c )
     {
           // method exception
     }
     catch ( NullPointerException c )
     {
            //method exception
     }
}