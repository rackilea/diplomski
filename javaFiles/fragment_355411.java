import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComponentMovedTest extends JPanel
{
    Dimension size = new Dimension( 0, 0 );

    private ComponentMovedTest()
    {
        final JFrame frame = new JFrame( "ComponentMovedTest" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        // NOTE: With a proper layout manager, this ComponentListener may
        //       not be necessary, as the layout manager would likely enforce
        //       minimum/maximum window sizing.  This means fix #2 could
        //       also be removed in favor of setting min/max/pref size,
        //       based on the layout manager.
        frame.addComponentListener( new ComponentAdapter()
        {
            @Override
            public void componentResized( ComponentEvent e )
            {
                if (frame.getExtendedState() != JFrame.MAXIMIZED_BOTH)
                {
                    // FIX #3: resize the window to the default size
                    //         whenever resized.
                    frame.setSize(size);
                }
            }
        });

        // FIX #1: Extend after setting visible.
        frame.setVisible( true );
        frame.setExtendedState( JFrame.MAXIMIZED_BOTH );

        // FIX #2: Set a default window size.
        size = frame.getSize();
    }

    public static void main( String[] args )
    {
        new ComponentMovedTest();
    }
}