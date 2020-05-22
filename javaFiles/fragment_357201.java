addKeyPressHandler( new KeyPressHandler()
{
  public void onKeyPress( KeyPressEvent event )
  {
   char charCode = event.getCharCode();
   if ( Character.isDigit( charCode ) )
   {
    System.out.println("This is a digit!!!");
   }
  }
}