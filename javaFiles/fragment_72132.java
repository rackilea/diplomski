import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ComboBoxUpdate {

    public static void main(String[] args) {
        new ComboBoxUpdate();
    }

    public ComboBoxUpdate() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
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

        private JComboBox comboBox;
        private JLabel option1;
        private JLabel option2;
        private JLabel option3;

        public TestPane() {
            comboBox = new JComboBox(new String[]{"Choice 1", "Choice 2", "Choice 3"});
            option1 = new JLabel("Bananas");
            option2 = new JLabel("Appels");
            option3 = new JLabel("Grapes");
            option1.setVisible(false);
            option2.setVisible(false);
            option3.setVisible(false);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(comboBox, gbc);
            add(option1, gbc);
            add(option2, gbc);
            add(option3, gbc);

            comboBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    switch (e.getStateChange()) {
                        case ItemEvent.SELECTED:
                            Object value = comboBox.getSelectedItem();
                            option1.setVisible(false);
                            option2.setVisible(false);
                            option3.setVisible(false);
                            if ("Choice 1".equals(value)) {
                                option1.setVisible(true);
                            } else if ("Choice 2".equals(value)) {
                                option2.setVisible(true);
                            } else if ("Choice 3".equals(value)) {
                                option3.setVisible(true);
                            }
                            break;
                    }
                }
            });

            comboBox.setSelectedItem(null);
        }
    }
}