import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StackExemple {

    public StackExemple() {
        JFrame frame = new JFrame();
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        CustomPanel customPanel1 = new CustomPanel(Color.blue);
        CustomPanel customPanel2 = new CustomPanel(Color.red);
        CustomPanel customPanel3 = new CustomPanel(Color.green);
        container.add(customPanel1);
        container.add(customPanel2);
        container.add(customPanel3);
        frame.getContentPane().add(container);
        frame.pack();
        frame.setVisible(true);
        for (Component comp : container.getComponents()) {
            CustomPanel panel = (CustomPanel) comp;
            System.out.println("Hello World");
        }
    }

    private class CustomPanel extends JPanel {

        private BufferedImage image;

        @Override
        public Dimension getMinimumSize() {
            return new Dimension(100, 80);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 160);
        }

        @Override
        public Dimension getMaximumSize() {
            return new Dimension(400, 320);
        }

        public CustomPanel(Color c) {
            setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createEmptyBorder(10, 10, 10, 10), 
                    BorderFactory.createLineBorder(Color.black, 1)));
            //setBorder(BorderFactory.createCompoundBorder(
            //BorderFactory.createLineBorder(Color.black, 1), 
            //BorderFactory.createEmptyBorder(10, 10, 10, 10)));
            setBackground(c);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StackExemple stackExemple = new StackExemple();
            }
        });
    }
}