import java.awt.EventQueue;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TableOptionPane {

    public static void main(String[] args) {
        new TableOptionPane();
    }

    public TableOptionPane() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                Integer[][] values = new Integer[10][3];
                StringBuilder string = new StringBuilder();
                for (int i = 1; i < 11; i++) {
                    values[i - 1][0] = i;
                    values[i - 1][1] = i * i;
                    values[i - 1][2] = i * i * i;
                }
                DefaultTableModel model = new DefaultTableModel(values, new Object[]{"i", "i * i", "i * i * i"});
                JTable table = new JTable(model);
                JOptionPane.showMessageDialog(null, new JScrollPane(table), "Data", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}