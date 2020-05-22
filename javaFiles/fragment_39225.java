import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class TableFoo extends JPanel {
    private static final String[] HEADER = new String[] { "Country", "ID", "WAN IP", "User", "OS", "Java version" };
    private static final int PREF_W = 500;
    private static final int PREF_H = 400;
    private DefaultTableModel model = new DefaultTableModel(HEADER, 0);
    private JTable table = new JTable(model);

    public TableFoo() {
        for (int count = 0; count < 50; count++) {
            model.addRow(new Object[] { "data1", "data2", "data3", "data4", "data5", "data6" });
        }

        for (int count = 0; count < 70; count++) {
            model.addRow(new Object[] { "data100", "data200", "data300", "data400", "data500", "data600" });
        }

        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("TableFoo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TableFoo());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}