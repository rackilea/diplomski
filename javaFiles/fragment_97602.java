import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class TestTableLoad {

    public static void main(String[] args) {
        new TestTableLoad();
    }

    public TestTableLoad() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JPanel {

        private JTable table;

        public TestPane() {
            table = new JTable();
            setLayout(new BorderLayout());
            add(new JScrollPane(table));

            JButton btn = new JButton("Populate");
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Object[]> values = new ArrayList<>(1000);
                    for (int index = 0; index < 1000; index++) {
                        Object[] row = new Object[3];
                        row[0] = index;
                        row[1] = (int)(Math.random() * 100);
                        row[2] = (int)(Math.random() * 100);
                        values.add(row);
                    }
                    DefaultTableModel model = new DefaultTableModel(new Object[]{"dd", "nn", "mm"}, 0);
                    table.setModel(model);
                    for (Object[] obj : values) {
                        model.addRow(obj);
                    }
                }
            });
            add(btn, BorderLayout.SOUTH);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }        
    }    
}