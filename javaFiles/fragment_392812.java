import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class JTableComponent {
    public static void main(String[] args) {
        new JTableComponent();
    }

    public JTableComponent() {
        JFrame frame = new JFrame("Creating JTable Component Example!");
        JPanel panel = new JPanel();

        DefaultTableModel aModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        Staff s1 = new Staff("vinod1", "BCA", "A", "10000");
        Staff s2 = new Staff("vinod2", "BCA", "A", "20000");
        Staff s3 = new Staff("vinod3", "BCA", "A", "30000");
        Staff s4 = new Staff("vinod4", "BCA", "A", "40000");
        ArrayList<Staff> l = new ArrayList<Staff>();// here you will get parser
                                                    // object this is as sample
        l.add(s1);
        l.add(s2);
        l.add(s3);
        l.add(s4);
        Iterator<Staff> is = l.iterator();

        String col[] = { "firstname", "lastname", "nickname", "salary" };
        aModel.setColumnIdentifiers(col);
        JTable table = new JTable(aModel);
        while (is.hasNext()) {
            Staff t = is.next();
            String firstname = t.getFirstname();
            String lastname = t.getLastname();
            String nickname = t.getNickname();
            String salary = t.getSalary();
            String temp[] = { firstname, lastname, nickname, salary };
            aModel.addRow(temp);
        }
        table.setModel(aModel);
        panel.add(table, BorderLayout.CENTER);

        frame.add(panel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}