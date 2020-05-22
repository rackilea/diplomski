public class Try extends JPanel
{
    @Override
    public void paintComponent ( final Graphics g )
    {
        super.paintComponent ( g );

        final Graphics2D g2d = ( Graphics2D ) g;
        g2d.drawString ( Long.toString ( System.currentTimeMillis () ), 25, 35 );

        System.out.println ( "repainted" );
    }

    public static void main ( final String[] args )
    {
        SwingUtilities.invokeLater ( new Runnable ()
        {
            @Override
            public void run ()
            {
                final JFrame f = new JFrame ();

                final Try t = new Try ();
                f.getContentPane ().add ( t );

                f.setSize ( 500, 600 );
                f.setVisible ( true );

                new Thread ( new Runnable ()
                {
                    @Override
                    public void run ()
                    {
                        try
                        {
                            while ( true )
                            {
                                t.repaint ();
                                Thread.sleep ( 25 );
                            }
                        }
                        catch ( final InterruptedException e )
                        {
                            //
                        }
                    }
                } ).start ();
            }
        } );
    }
}