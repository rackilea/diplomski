import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @see https://stackoverflow.com/a/14858272/230513
 * @see https://stackoverflow.com/a/8504753/230513
 * @see https://stackoverflow.com/a/14011536/230513
 */
public class DynamicGroupLayout {

    private static final int NUM = 30;
    private JTextField[] fields = new JTextField[NUM];
    private JLabel[] labels = new JLabel[NUM];

    private JPanel create() {
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        GroupLayout.ParallelGroup parallel = layout.createParallelGroup();
        layout.setHorizontalGroup(layout.createSequentialGroup().addGroup(parallel));
        GroupLayout.SequentialGroup sequential = layout.createSequentialGroup();
        layout.setVerticalGroup(sequential);
        for (int i = 0; i < NUM; i++) {
            labels[i] = new JLabel(String.valueOf(i + 1), JLabel.RIGHT);
            fields[i] = new JTextField(String.valueOf("String " + (i + 1)));
            labels[i].setLabelFor(fields[i]);
            parallel.addGroup(layout.createSequentialGroup().
                addComponent(labels[i]).addComponent(fields[i]));
            sequential.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                addComponent(labels[i]).addComponent(fields[i]));
            layout.linkSize(SwingConstants.HORIZONTAL, labels[i], labels[0]);
        }
        return panel;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JPanel panel = new DynamicGroupLayout().create();
                JScrollPane jsp = new JScrollPane(panel) {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(320, 240);
                    }
                };
                JOptionPane.showMessageDialog(null,
                    jsp, "Data", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }
}