import java.awt.*;
import javax.swing.*;

public class TestLotus {
    public static void main(final String[] arguments) {
        SwingUtilities.invokeLater(() -> new TestLotus().createAndShowGui());
    }

    private void createAndShowGui() {
        final JFrame frame = new JFrame("Stack Overflow");
        frame.setBounds(100, 100, 800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JLabel h1 = new JLabel("Some text");
        JTextField text = new JTextField(15);

        JPanel panel = new JPanel();

        h1.setBounds(180,50,120,20); //this is it
        text.setBounds(180,90,120,20); // and this

        panel.setLayout(null);
        panel.add(h1);
        panel.add(text);

        frame.getContentPane().add(panel);
        frame.setVisible(true);

        printComponents(frame, "");
    }

    private void printComponents(Container container, String indent) {
        for (Component component : container.getComponents()) {
            System.out.println(indent + "component.getClass().getName(): " 
                               + component.getClass().getName());
            System.out.println(indent + "component.getBounds(): " 
                               + component.getBounds());

            if (component instanceof Container) {
                printComponents((Container) component, indent + "    ");
            }
        }
    }
}