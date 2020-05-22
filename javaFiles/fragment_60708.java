import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class TableIcon extends JFrame
{
    public TableIcon()
    {
        ImageIcon backIcon = getImage("/images/bac.png");
        ImageIcon exitIcon = getImage("/images/exit.png");
        ImageIcon forwardIcon = getImage("/images/forward.png");

        String[] columnNames = {"Picture", "Description"};
        Object[][] data =
        {
            {backIcon, "BACK"},
            {exitIcon, "EXIT"},
            {forwardIcon, "FORWARD"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable( model )
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/appIcon.png"));
        //model.addRow(new Object[]{icon, "Text"});
        //model.addRow(data[0]);
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    private ImageIcon getImage(String path)
    {
        java.net.URL url = getClass().getResource(path);
        if (url != null)
            return (new ImageIcon(url));
        else
        {
            System.out.println(url);
            return null;
        }
    }

    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        TableIcon frame = new TableIcon();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }

}