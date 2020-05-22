import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TestTableLayout {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JPanel panel = new JPanel(new BorderLayout());
                panel.setPreferredSize(new Dimension(400, 400));

                final DefaultTableModel model = new DefaultTableModel(0, 1);
                JTable table = new JTable(model) {
                    @Override
                    public Dimension getPreferredScrollableViewportSize() {
// view port size should be the same as the preferred size
// limited to the height threshold
                        Dimension size = super.getPreferredSize();
                        size.height = Math.min(size.height, 100);
                        return size;
                    }
                };

                new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        model.addRow(new Object[] { "Extra row!" });
// trigger a relayout of the panel
                        panel.revalidate();
                        panel.repaint();
                    }
                }).start();

                panel.add(new JScrollPane(table), BorderLayout.PAGE_START);

                JLabel label = new JLabel("my label");
                label.setVerticalAlignment(JLabel.TOP);
                panel.add(label, BorderLayout.CENTER);

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.getContentPane().add(panel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}