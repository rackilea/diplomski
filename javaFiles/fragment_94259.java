String buzz = null;  // Assuming Buzz field is a string in this example
Field fBuzz = null;
try
{
    Class<?> cBuzz = theBuzzInstance.getClass();
    fBuzz = cBuzz.getDeclaredField( "buzz" );
    fBuzz.setAccessible( true );
    buzz = ( String ) fBuzz.get( theBuzzInstance );

    String newBuzz = "Hacked!";
    fBuzz.set( theBuzzInstance, newBuzz );
}
catch( Exception e )
{
    // TODO: Error handling
}