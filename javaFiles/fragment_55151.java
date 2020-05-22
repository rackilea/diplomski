import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableFromFile extends JPanel
{
    public TableFromFile()
    {
        setLayout( new BorderLayout() );

        JTable table = new JTable( getTableModel() );
        table.setPreferredScrollableViewportSize(table.getPreferredSize());
        JScrollPane scrollPane = new JScrollPane( table );
        add( scrollPane );
    }

    private TableModel getTableModel()
    {
        String delimiter = ":";
        DefaultTableModel model = new DefaultTableModel();

        try
        {
            BufferedReader reader = getFileReader();

            //  First line will contain the column names

            String line = reader.readLine();
            model.setColumnIdentifiers( line.split(delimiter) );

            //  Remaining lines in the file will be the data

            while ((line = reader.readLine()) != null)
            {
                model.addRow( line.split(delimiter) );
            }

            reader.close();
        }
        catch(Exception e) { System.out.println(e); }


        return model;
    }

    private BufferedReader getFileReader()
    {
        //  Create data to simulate reading data from a file

        String data =
            "Letter:Number\n" +
            "A:1\n" +
            "B:2\n" +
            "C:3";

        BufferedReader reader = new BufferedReader( new StringReader( data ) );

        //  In your real application the data would come from a file

        //Reader reader = new BufferedReader( new FileReader(...) );

        return reader;
    }

    private static void createAndShowUI()
    {
        JFrame frame = new JFrame("Table From File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new TableFromFile() );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowUI();
            }
        });
    }
}