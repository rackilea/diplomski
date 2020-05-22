import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

public class ResizeColumnListener implements MouseListener
{
    private static Cursor resizeCursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);

    private MouseListener uiListener;
    private JTableHeader header;
    private TableColumnAdjuster tca;

    public ResizeColumnListener(JTable table)
    {
        header = table.getTableHeader();
        tca = new TableColumnAdjuster( table );

        MouseListener[] listeners = header.getMouseListeners();

        for (MouseListener ml: listeners)
        {
            String className = ml.getClass().toString();

            if (className.contains("BasicTableHeaderUI"))
            {
                uiListener = ml;
                header.removeMouseListener(ml);
                header.addMouseListener( this );
            }
        }
    }

    @Override
    public void mouseClicked( MouseEvent e )
    {
        if (header.getCursor() != resizeCursor)
        {
            uiListener.mouseClicked( e );
            return;
        }

        //  Handle the double click event to resize the column
        //  Note: The last 3 pixels + 3 pixels of next column are for resizing,
        //  so we need to adjust the mouse point to get the actual column.

        if (e.getClickCount() == 2)
        {
            Point p = e.getPoint();
            p.x -= 3;
            int column = header.columnAtPoint( p );
            tca.adjustColumn( column );

            //  Generate event to reset the cursor

            header.dispatchEvent(new MouseEvent(
                header,
                MouseEvent.MOUSE_MOVED,
                e.getWhen(),
                e.getModifiers(),
                e.getX(),
                e.getY(),
                0,
                false));
        }
    }

    @Override
    public void mouseEntered( MouseEvent e )
    {
        uiListener.mouseEntered( e );
    }

    @Override
    public void mouseExited( MouseEvent e )
    {
        uiListener.mouseExited( e );
    }

    @Override
    public void mousePressed( MouseEvent e )
    {
        uiListener.mousePressed( e );
    }

    @Override
    public void mouseReleased( MouseEvent e )
    {
        uiListener.mouseReleased( e );
    }

    public static void main(String[] args)
    {
        try
        {
//          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (Exception e) { }

        DefaultTableModel model = new DefaultTableModel(5, 5);
        model.setValueAt("Row 0 : Column 0", 0, 0);
        model.setValueAt("Row 1 : Column 1", 1, 1);
        model.setValueAt("Row 2 : Column 2", 2, 2);
        model.setValueAt("Row 3 : Column 3", 3, 3);
        model.setValueAt("Row 4 : Column 4", 4, 4);

        JTable table = new JTable( model );
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane( table );

        new ResizeColumnListener(table);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.add( scrollPane );
        frame.setSize(400, 200);
        frame.setVisible(true);
    }
}