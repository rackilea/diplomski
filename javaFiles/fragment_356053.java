public class ScreenBoundsExample
{
    public static void main ( String[] args )
    {
        final GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment ().getDefaultScreenDevice ();
        final GraphicsDevice[] devices = GraphicsEnvironment.getLocalGraphicsEnvironment ().getScreenDevices ();
        for ( final GraphicsDevice d : devices )
        {
            if ( d == device )
            {
                System.out.println ( "Main screen bounds: " + d.getDefaultConfiguration ().getBounds () );
            }
            else
            {
                System.out.println ( "Secondary screen bounds: " + d.getDefaultConfiguration ().getBounds () );
            }
        }
    }
}