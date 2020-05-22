import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TestCBoxListCellRenderer {

    public TestCBoxListCellRenderer() {
        String[] list = {"Hello World 1", "Hello World 2", "Hello World 3"};
        JComboBox box = new JComboBox(list);
        box.setRenderer(new CBoxListCellRenderer());

        JOptionPane.showMessageDialog(null, box, "Check out this Renderer", JOptionPane.PLAIN_MESSAGE);
    }

    public static void main(String[] args) {
        new TestCBoxListCellRenderer();
    }

    class BackGroundPanel extends JPanel {

        BufferedImage img = null;

        public BackGroundPanel() {
            try {
                img = ImageIO.read(TestCBoxListCellRenderer.class.getResource("/res/leafcell.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(),
                    0, 0, img.getWidth(), img.getHeight(), this);
        }
    }

    private class CBoxListCellRenderer implements ListCellRenderer {

        final BackGroundPanel panel = new BackGroundPanel();
        JLabel label = new JLabel();

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

            label.setText(value.toString());
            panel.add(label);

            return panel;
        }
    }
}