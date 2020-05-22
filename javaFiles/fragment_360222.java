import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class TableFile extends JFrame
    implements ActionListener, Runnable
{
    JTable table;
    DefaultTableModel model;
    JTextField path;
    JLabel currentFile;
    JButton getFiles;
    int totalFiles;
    int totalDirectories;

    public TableFile()
    {
        path = new JTextField("C:\\java");
        add(path, BorderLayout.PAGE_START );

        getFiles = new JButton( "Get Files" );
        getFiles.addActionListener( this );
        add(getFiles, BorderLayout.LINE_START );

        String[] columnNames = {"IsFile", "Name"};

        model = new DefaultTableModel(columnNames, 0);
        table = new JTable( model );

        JScrollPane scrollPane = new JScrollPane( table );
        add(scrollPane, BorderLayout.PAGE_END);

        currentFile = new JLabel(" ");
//      add(currentFile, BorderLayout.PAGE_END); // displays filename in label
    }

    public void actionPerformed(ActionEvent e)
    {
        model.setNumRows(0);

        new Thread( this ).start();

        table.requestFocusInWindow();
    }

    public void run()
    {
        totalFiles = 0;
        totalDirectories = 0;
        listFiles( new File( path.getText() ) );
        System.out.println("Directories: " + totalDirectories);
        System.out.println("Files      : " + totalFiles);
    }

    private void listFiles(File dir)
    {
        updateTable( dir );
        totalDirectories++;
        System.out.println("Processing directory: " + dir);

        //  add a delay to demonstrate processing one directory at a time

        try { Thread.sleep(500); }
        catch(Exception e) {}

        File[ ] entries = dir.listFiles( );
        int size = entries == null ? 0 : entries.length;

        for(int j = 0; j < size; j++)
        {
            if (entries[j].isDirectory( ))
            {
                listFiles( entries[j] );
            }
            else
            {
                updateTable( entries[j] );
                currentFile.setText( entries[j].toString() );
                totalFiles++;
            }
        }
    }

    private void updateTable(final File file)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                Vector<Object> row = new Vector<Object>(2);
                row.addElement( new Boolean( file.isFile() ) );
                row.addElement( file.toString() );
                model.addRow( row );
                int rowCount = table.getRowCount() - 1;
                table.changeSelection(rowCount, rowCount, false, false);
            }
        });
    }

    public static void main(String[] args)
    {
        TableFile frame = new TableFile();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setLocationRelativeTo( null );
        frame.setVisible(true);
    }
}