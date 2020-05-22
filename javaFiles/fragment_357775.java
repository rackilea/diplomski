import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class DatabaseInformation extends JFrame implements ActionListener
{
    DatabaseMetaData dmd;
    ResultSet rs;
    ResultSetMetaData md;
    int columns;
    JComboBox comboBox;
    JTable table;
    String catalog;

    public DatabaseInformation()
    {
        comboBox = new JComboBox();
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try
        {
            //  Connect to the Database

            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
//            String url = "jdbc:odbc:Teenergy";  // if using ODBC Data Source name
            String url = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=c:/teenergy/data/teenergy.mdb";
            String userid = "";
            String password = "";

            Class.forName( driver );
            Connection connection = DriverManager.getConnection( url, userid, password );
            dmd = connection.getMetaData();

            //  Get the first Catalog
            //  Note: the result set can contain multiple catalogs, just look at the first one

            rs = dmd.getCatalogs();

            if (rs.next())
            {
                catalog = rs.getObject(1).toString();
                System.out.println( catalog );
            }

            rs.close();

            //  Get Tables

            rs = dmd.getTables(catalog, null, null, new String[] { "TABLE" });
            md = rs.getMetaData();
            columns = md.getColumnCount();

            while (rs.next())
            {
                   comboBox.addItem( rs.getObject(3) );
            }

            rs.close();

        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        comboBox.addActionListener( this );
        getContentPane().add(comboBox, BorderLayout.NORTH);

        //  Create table with database data

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    public void actionPerformed(ActionEvent e)
    {
        String table = (String)comboBox.getSelectedItem();
        displayTableColumns( table );
    }

    private void displayTableColumns(String tableName)
    {
        try
        {
            //  Get Columns

            rs = dmd.getColumns(catalog, null, tableName, null);
            md = rs.getMetaData();
            int columns = md.getColumnCount();
            Vector columnNames = new Vector(columns);
            Vector data = new Vector();

            //  Get column names

            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }

            //  Get row data

            while (rs.next())
            {
                Vector row = new Vector(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();

            //  Reset Table

            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel( model );
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

    }

    public static void main(String[] args)
    {
        DatabaseInformation frame = new DatabaseInformation();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }
}