// The basic window class (pretty much a constructor facade around JFrame)
public class Window extends JFrame {
    // constructor for creating windows
    public Window(int width, int height, String title, boolean resizable, int operation) {
        setLayout(new FlowLayout());
        setDefaultCloseOperation(operation);
        setSize(width, height);
        setTitle(title);
        setResizable(resizable);
        setLocationRelativeTo(null);
    }

    // factory method creating labels
    public static JLabel createLabel(String text, int AY, int AX) {
        JLabel label = new JLabel(text, JLabel.CENTER);
        label.setAlignmentX(AX);
        label.setAlignmentY(AY);
        label.setVisible(true);
        return label;
    }

    // factory method creating text fields
    public static JTextField createTextBox(String text, Color fg, Color bg, int max) {
        JTextField textField = new JTextField(text, max);
        textField.setForeground(fg);
        textField.setBackground(bg);
        textField.setVisible(true);
        return textField;
    }

    // factory method creating buttons
    public static JButton createButton(String text, Color fg, Color bg) {
        JButton button = new JButton(text);
        button.setForeground(fg);
        button.setBackground(bg);
        button.setVisible(true);
        return button;
    }
}