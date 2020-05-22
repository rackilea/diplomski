import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

@SuppressWarnings("serial")
public class ClearThreeDots extends JPanel {
    private JTextField textField = new JTextField(40);

    public ClearThreeDots() {
        ((PlainDocument) textField.getDocument()).setDocumentFilter(new MyDocFilter());
        add(textField);
    }

    private static void createAndShowGui() {
        ClearThreeDots mainPanel = new ClearThreeDots();

        JFrame frame = new JFrame("Clear Three Dots");
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