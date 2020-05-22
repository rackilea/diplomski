import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.table.*;

public class SSCCE extends JPanel
{
    public SSCCE()
    {
        Vector<String> header = new Vector<String>();
        header.add("Select");
        header.add("Column1");
        header.add("Column2");
        header.add("Column3");

        Vector<Vector<Object>> data = new Vector<Vector<Object>>();

        for (int row = 0; row < 5; row++)
        {
            Vector<Object> d = new Vector<Object>();
            d.add( Boolean.FALSE );

            for (int column = 0; column < 3; column++)
            {
                d.add(row + " : " + column);
            }

            data.add(d);
        }

        DefaultTableModel model = new DefaultTableModel(data, header);
        JTable table = new JTable( model );
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        TableColumn tc = table.getColumnModel().getColumn(0);
        tc.setCellRenderer( table.getDefaultRenderer( Boolean.class ) );
        tc.setCellEditor( table.getDefaultEditor( Boolean.class ) );

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("SSCCE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new SSCCE() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}