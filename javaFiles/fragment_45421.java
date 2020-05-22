import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class JLabelFocus extends JPanel {
    private String[] labelTexts = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public JLabelFocus() {
        setPreferredSize(new Dimension(400, 200));
        for (String text : labelTexts) {
            JLabel label = new JLabel(text);
            label.setFocusable(true);
            label.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    System.out.println("Focus now on: " + label.getText());
                    label.setBorder(BorderFactory.createLineBorder(Color.RED));
                } 

                @Override
                public void focusLost(FocusEvent e) {
                    label.setBorder(null);
                }
            });
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    label.requestFocusInWindow();
                }
            });
            add(label);
        }
    }

    private static void createAndShowGui() {
        JLabelFocus mainPanel = new JLabelFocus();

        JFrame frame = new JFrame("JLabelFocus");
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