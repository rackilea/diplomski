import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AdvancedLayout {

    public static void main(String[] args) {
        new AdvancedLayout();
    }

    public AdvancedLayout() {
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

        private JLabel image;
        private JButton button;
        private JLabel label;
        private JComboBox comboBox;
        private JButton otherButton;

        public TestPane() {
            setLayout(new GridBagLayout());
            image = new JLabel();
            button = new JButton("A button");
            label = new JLabel("A label");
            comboBox = new JComboBox();
            otherButton = new JButton("Other");
            try {
                image.setIcon(new ImageIcon(ImageIO.read(new File("/path/to/a/image"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.6666666666666667;
            gbc.weighty = 1f;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            add(image, gbc);

            gbc.gridheight = 1;
            gbc.gridx++;
            gbc.weightx = 0.3333333333333333f;
            gbc.weighty = 0.25f;
            add(button, gbc);
            gbc.gridy++;
            add(label, gbc);
            gbc.gridy++;
            add(comboBox, gbc);
            gbc.gridy++;
            add(otherButton, gbc);

        }

    }

}