import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Patrick Ott <Patrick.Ott@professional-webworkx.de>
 * @version 1.0
 */
public class MainFrame extends JFrame {

    private String[][] rowData = 
    {
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Max", "Mustermann", "Musterhausen"},
        {"Petra", "Mustermann", "Musterhausen"}
    };

    private String[] columnData = 
    {
        "Firstname", "Lastname", "City"
    };
    private JTable jTable;

    public MainFrame() {
        jTable = new JTable(rowData, columnData);
        jTable.setName("CRM Table");
    }

    public void createAndShowGui() {
        this.setTitle("JTable in JScrollPane");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.getContentPane().add(new JLabel("CRM System"), BorderLayout.NORTH);
        JScrollPane scrollPane = new JScrollPane(jTable);
        this.getContentPane().add(scrollPane, BorderLayout.CENTER);
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
        Container parent = jTable.getParent().getParent();
        JScrollPane enclosing = (JScrollPane)parent;
        parent.remove(jTable);
        parent.add(new JLabel("Test"));
        // System.out.println(enclosing.getClass().getSimpleName());
    }
}