import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestLayout31 {

    public static void main(String[] args) {
        new TestLayout31();
    }

    public TestLayout31() {
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

        public TestPane() {

            JLabel lblRes = new JLabel("Resident Name");
            JLabel lblRoomNo = new JLabel("RoomNo");
            JLabel lblAge = new JLabel("Age");
            JLabel lblGender = new JLabel("Gender");
            JLabel lblCare = new JLabel("Care level");

            JTextField fldRes = new JTextField("john smith", 20);
            JTextField fldRoomNo = new JTextField(10);
            JComboBox cmbAge = new JComboBox(new Object[]{51});
            JComboBox cmbGener = new JComboBox(new Object[]{"M", "F"});
            JComboBox cmbCare = new JComboBox(new Object[]{"Low"});

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.insets = new Insets(1, 1, 1, 1);
            add(lblRes, gbc);

            gbc.gridx++;
            gbc.gridwidth = 4;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(fldRes, gbc);

            gbc.gridx = 7;
            gbc.gridwidth = 1;
            gbc.fill = GridBagConstraints.NONE;
            add(lblRoomNo, gbc);

            gbc.gridx++;
            add(fldRoomNo, gbc);

            gbc.gridy++;
            gbc.gridx = 1;
            add(lblAge, gbc);
            gbc.gridx++;
            add(cmbAge, gbc);
            gbc.gridx++;
            add(lblGender, gbc);
            gbc.gridx++;
            add(cmbGener, gbc);
            gbc.gridx++;
            gbc.gridwidth = 2;
            add(lblCare, gbc);
            gbc.gridx += 2;
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(cmbCare, gbc);

        }
    }

}