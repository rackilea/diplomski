import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class JTableExample extends JFrame
{
    private static final long serialVersionUID = 1L;

    private final JTable table;

    public JTableExample()
    {
        // headers and data for the table
        final String[] columns = new String[]{"Id", "Name"};
        final Object[][] data = new Object[][]{{1, "Alice"}, {2, "Bob"}, {3, "Charlie"},};

        // create table with data
        table = new JTable( data, columns );
        this.add( new JScrollPane( table ) );

        // Add key listener to trigger re-selection of columns
        table.addKeyListener( new KeyAdapter()
        {
            @Override
            public void keyReleased( final KeyEvent e )
            {
                // Re-select on event dispatch thread (EDT)
                if( e.getKeyCode() == KeyEvent.VK_1 )
                {
                    reselectTable();
                }

                // Re-select on a thread that is not the EDT
                if( e.getKeyCode() == KeyEvent.VK_2 )
                {
                    new Thread( () -> reselectTable() ).start();
                }

                // Re-select on a thread that is not the EDT, but using invokeLater to get back to the EDT
                if( e.getKeyCode() == KeyEvent.VK_3 )
                {
                    new Thread( () -> SwingUtilities.invokeLater( () -> reselectTable() ) ).start();
                }
            }
        } );

        // Setup JFrame
        setTitle( "JTable Example" );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        pack();
        setVisible( true );
    }

    public static void main( final String[] args )
    {
        SwingUtilities.invokeLater( new Runnable()
        {
            @Override
            public void run()
            {
                new JTableExample();
            }
        } );
    }

    private void reselectTable()
    {
        System.out.println( "isEventDispatchThread:" + SwingUtilities.isEventDispatchThread() );

        final ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.clearSelection();
        // PUT BREAKPOINT HERE
        // Selection in rendered GUI is gone here when not in the EDT
        selectionModel.addSelectionInterval( 0, 0 );
        selectionModel.addSelectionInterval( 2, 2 );
    }
}