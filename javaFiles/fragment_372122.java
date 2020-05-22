import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class MarginDemo {
    private static void createAndShowUI() {
        final JTextPane textPane = new JTextPane();
        final JScrollPane scrollPane = new JScrollPane(textPane);

        String text = "Lorem ipsum dolor sit amet, "
                + "consectetur adipiscing elit."
                + "Fusce nec sapien id diam consequat adipiscing.";
        textPane.setText(text);

        JFrame frame = new JFrame("MarginDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(scrollPane);

        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                FontMetrics metrics = textPane.getFontMetrics(textPane
                        .getFont());
                textPane.setMargin(new Insets(scrollPane.getViewport()
                        .getHeight() - metrics.getHeight(), 0, 0, 0));
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
}