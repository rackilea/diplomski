import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class ScrollTable {

    public static void main(String[] args) {
        new ScrollTable();
    }

    public ScrollTable() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final DefaultTableModel model = new DefaultTableModel(new Object[]{"Test"}, 0);
                for (int index = 0; index < 100; index++) {
                    model.addRow(new Object[]{index});
                }

                final JTable table = new JTable(model);

                JButton add = new JButton("Add");
                add.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Object[]{model.getRowCount()});
                        Rectangle badRect = table.getCellRect(model.getRowCount(), 0, true);
                        Rectangle goodRect = table.getCellRect(model.getRowCount() - 1, 0, true);

                        System.out.println("bad = " + badRect);
                        System.out.println("goodRect = " + goodRect);

                        table.scrollRectToVisible(goodRect);
                    }
                });

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new JScrollPane(table));
                frame.add(add, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}