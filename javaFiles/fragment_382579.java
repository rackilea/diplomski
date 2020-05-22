public static void main( String[] args )
{
   java.awt.GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();

   for ( int i = 0; i < devices.length; i++ )
   {
      System.out.println( "Device " + i + " width: " + devices[ i ].getDisplayMode().getWidth() );
      System.out.println( "Device " + i + " height: " + devices[ i ].getDisplayMode().getHeight() );
   }
}