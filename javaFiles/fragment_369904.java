import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;    
import javax.swing.*;

@SuppressWarnings("serial")
public class UserInterfacePanel extends JPanel {
    private static final Insets INSETS = new Insets(3, 3, 3, 3);
    private static final int PREF_W = 800;
    private static final int PREF_H = 650;
    private JToggleButton startButton = new JToggleButton("Start");
    private JToggleButton stopButton = new JToggleButton("Long Texted Title");

    public UserInterfacePanel() {
        setup();
    }

    private void setup() {
        setLayout(new GridBagLayout());  // **** change

        add(startButton, createGbc(0, 0));
        add(stopButton, createGbc(1, 0));
    }


    private GridBagConstraints createGbc(int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = INSETS;
        return gbc;
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }


    private static void createAndShowGui() {
        UserInterfacePanel mainPanel = new UserInterfacePanel();

        JFrame frame = new JFrame("UserInterfacePanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}