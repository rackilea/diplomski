import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BoxLayoutExample {
    public static void main(String[] arguments) {
        SwingUtilities.invokeLater(() -> new BoxLayoutExample().createAndShowGui());
    }

    private void createAndShowGui() {
        JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(28, 28, 28, 28));

        JLabel label = new JLabel("Some longer text here......");
        panel.add(label);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 42)));

        String text = "image (can be done with \"new ImageIcon(\"image path\")\")";
        JLabel image = new JLabel(text);
        panel.add(image);
        image.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(Box.createRigidArea(new Dimension(0, 42)));

        JButton button = new JButton("a button");
        panel.add(button);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}