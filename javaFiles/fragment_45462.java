import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText("Plain text with <strong>bold</strong> part.");
        frame.add(textPane);
        frame.setVisible(true);
    }
}