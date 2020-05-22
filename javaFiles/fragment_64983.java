public class FullscreenWindow
{
    public static void main ( final String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            @Override
            public void run ()
            {
                final JFrame frame = new JFrame ();
                frame.setExtendedState ( JFrame.MAXIMIZED_BOTH );
                frame.setUndecorated ( true );
                frame.setVisible ( true );
            }
        } );
    }
}