import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Frame2
{
    public static void main( String[] args )
    {
        final JFrame frame = new JFrame( );

        JButton button = new JButton( "press me" );
        button.addActionListener( new ActionListener( )
        {

            @Override
            public void actionPerformed( ActionEvent e )
            {
                frame.setTitle( "New Title" );
            }

        } );

        frame.setTitle( "Title" );
        frame.add( button );
        frame.setSize( 400, 400 );
        frame.setVisible( true );
    }
}