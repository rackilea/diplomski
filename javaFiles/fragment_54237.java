import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class Test {
    /**
     * Do this for thread safety
     * @param args
     */
    public static void main (String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createGUI();
            }
        });
    }

    /**
     * create the JFrame
     */
    private static void createGUI() {
        JFrame jf = new JFrame();

        addComponents(jf.getContentPane());

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
    }

    /**
     * add the components
     * @param pane
     */
    private static void addComponents(Container pane) {
        String [] [] data = {{"hallo","hallo","","","",""}, {"hallo","hallo","","","",""}};     
        String [] User = {"ID","Benutzername", "Name", "Vorname", "Geburtsdatum", "Wirt"};

        JTable tableUsers = new JTable(data,User);
        tableUsers.setPreferredScrollableViewportSize(new Dimension(500,50));
        tableUsers.setFillsViewportHeight(true);
        //add(new JScrollPane(tableUsers));
        JTableHeader header = tableUsers.getTableHeader();
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(header, BorderLayout.NORTH);
        panel.add(tableUsers, BorderLayout.CENTER);
        JScrollPane scrollPane = new JScrollPane(panel);
        pane.add(scrollPane);
        tableUsers.setBounds(29, 245, 580, 136);
        //pane.add(tableUsers);
    }
}