import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestTableModel01 {

    public static void main(String[] args) {
        new TestTableModel01();
    }

    public TestTableModel01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final DefaultTableModel model = new DefaultTableModel(new Object[]{"A", "B", "C", "D", "E"}, 0);
                JTable table = new JTable(model);

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(500, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (model.getRowCount() < 100) {
                            int row = model.getRowCount();
                            model.addRow(new Object[]{
                                row + "x" + 0,
                                row + "x" + 1,
                                row + "x" + 2,
                                row + "x" + 3,
                                row + "x" + 4
                            });
                        } else {
                            ((Timer)(e.getSource())).stop();
                        }
                    }
                });
                timer.start();
            }
        });
    }
}