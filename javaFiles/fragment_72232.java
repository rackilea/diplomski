import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FormLayout {

    public static void main(String[] args) {
        new FormLayout();
    }

    public FormLayout() {
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

            setLayout(new BorderLayout());

            JPanel content = new JPanel(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(8, 8, 8, 8);
            gbc.anchor = GridBagConstraints.EAST;

            content.add(new JLabel("Label 1"), gbc);
            gbc.gridy++;
            content.add(new JLabel("Label 2"), gbc);

            gbc.anchor = GridBagConstraints.WEST;
            gbc.gridy = 0;
            gbc.gridx++;
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            content.add(new JTextField(20), gbc);
            gbc.gridy++;
            content.add(new JTextField(20), gbc);

            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));    
            buttons.add(new JButton("Save"));
            buttons.add(new JButton("Close"));

            add(content);
            add(buttons, BorderLayout.SOUTH);
        }            
    }        
}