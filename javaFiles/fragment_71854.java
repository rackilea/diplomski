import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Frame
{
    public static void main( String[] args )
    {
        JFrame frame = new JFrame( );
        JEditorPane pane = new JEditorPane( );

        String t = "";
        for ( int i = 0 ; i < 10000 ; i++ ) t += "t";

        pane.setText( t );

        JScrollPane scroll = new JScrollPane( pane );

        scroll.addMouseWheelListener( new MouseWheelListener( )
        {
            @Override
            public void mouseWheelMoved( MouseWheelEvent e )
            {
                System.out.println( "Scroll" );
            }
        });

        frame.add( scroll );
        frame.setSize( 400, 400 );
        frame.setVisible( true );
    }
}