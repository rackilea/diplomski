import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SetText extends JPanel implements MouseMotionListener {

    private static final float POINTS = 40f;
    JTextField textField;
    private JLabel displayLabel = new JLabel("          ", SwingConstants.CENTER);

    public SetText() {
        textField = new JTextField("Hello world! How's it going?", 20);
        textField.addMouseMotionListener(this);

        // make the text bigger so easier to test
        textField.setFont(textField.getFont().deriveFont(Font.BOLD, POINTS));

        JLabel lbl = new JLabel("Text:");
        lbl.setFont(lbl.getFont().deriveFont(Font.BOLD, POINTS));
        displayLabel.setFont(displayLabel.getFont().deriveFont(Font.BOLD, POINTS));

        JPanel centerPanel = new JPanel();
        centerPanel.add(lbl);
        centerPanel.add(displayLabel);

        setLayout(new BorderLayout());
        add(textField, BorderLayout.PAGE_START);
        add(centerPanel, BorderLayout.CENTER);
    }

    public void mouseMoved(MouseEvent e) {
        int location = textField.viewToModel(e.getPoint());

        String text = textField.getText();
        if (text.isEmpty()) {
            return;
        }
        // if (location > 0 && location < text.length()) {
        if (location >= 0 && location < text.length()) {
            char c = textField.getText().charAt(location);
            displayLabel.setText(String.valueOf(c));
        } else if (location >= text.length()) {
            displayLabel.setText(text.substring(text.length() - 1));
        }
    }

    public void mouseDragged(MouseEvent e) {

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
           JFrame frame = new JFrame("Set Text");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame.add(new SetText());
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
        });
    }
}