import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class ClickDragLabel extends JPanel {
    public static final String IMG_PATH = "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/"
            + "Theodore_Comnenus-Ducas_cropped.jpg/133px-Theodore_Comnenus-Ducas_cropped.jpg";
    private static final int PREF_W = 1000;
    private static final int PREF_H = 850;
    private JLabel imageLabel;
    private JLabel textLabel = new JLabel("Some Random Text");

    public ClickDragLabel(Icon icon) {
        setBackground(Color.WHITE);
        imageLabel = new JLabel(icon);

        setLayout(null);
        imageLabel.setSize(imageLabel.getPreferredSize());
        textLabel.setSize(textLabel.getPreferredSize());

        imageLabel.setLocation(250, 250);
        textLabel.setLocation(10, 10);

        MyMouse myMouse = new MyMouse();
        imageLabel.addMouseListener(myMouse);
        imageLabel.addMouseMotionListener(myMouse);
        textLabel.addMouseListener(myMouse);
        textLabel.addMouseMotionListener(myMouse);

        add(imageLabel);
        add(textLabel);

    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    private class MyMouse extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            center(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            center(e);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            center(e);
        }

        private void center(MouseEvent e) {
            JComponent component = (JComponent) e.getSource();
            Container container = component.getParent();

            Point mousePoint = e.getLocationOnScreen();
            Point containerLocation = container.getLocationOnScreen();
            Dimension componentSize = component.getSize();

            int x = mousePoint.x - componentSize.width / 2 - containerLocation.x;
            int y = mousePoint.y - componentSize.height / 2 - containerLocation.y;
            component.setLocation(x, y);
            container.repaint();
        }

    }

    private static void createAndShowGui() {
        Image img = null;
        try {
            URL imgUrl = new URL(IMG_PATH);
            img = ImageIO.read(imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Icon icon = new ImageIcon(img);

        ClickDragLabel mainPanel = new ClickDragLabel(icon);

        JFrame frame = new JFrame("Click-Drag Label");
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