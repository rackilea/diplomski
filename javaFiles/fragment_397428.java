import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class LocationExample {

    private JButton button;
    private JTextField tField;
    private JPanel contentPane;

    private static final int RECTANGLE_DIMENSION = 50;

    private List<Rectangle> rectangles;
    private Random random;

    private MouseAdapter mouseAdapter = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent me) {
            int x = me.getX();
            int y = me.getY();
            for (Rectangle rectangle : rectangles) {
                if (rectangle.contains(x, y)) {
                    contentPane.setBackground(getRandomColor());
                }
            }
        }
    };

    private ComponentAdapter componentAdapter = new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent ce) {
            setRectangleBounds();
        }
    };

    public LocationExample() {
        random = new Random();
        rectangles = new ArrayList<Rectangle>();
    }   

    private void displayGUI() {
        JFrame frame = new JFrame("Location Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        contentPane = new JPanel() {
            @Override
            public Dimension getPreferredSize() {
                return (new Dimension(300, 300));
            }
        };
        contentPane.setOpaque(true);
        contentPane.addMouseListener(mouseAdapter);
        contentPane.addComponentListener(componentAdapter);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

        setRectangleBounds();
    }

    private void setRectangleBounds() {
        getRectangle(contentPane.getWidth() - RECTANGLE_DIMENSION, 0);
        getRectangle(0, contentPane.getHeight() - RECTANGLE_DIMENSION);
        getRectangle((contentPane.getWidth() / 2) - (RECTANGLE_DIMENSION / 2),
                    (contentPane.getHeight() / 2) - (RECTANGLE_DIMENSION / 2));
    }

    private void getRectangle(int x, int y) {
        rectangles.add(new Rectangle(x, y, RECTANGLE_DIMENSION, RECTANGLE_DIMENSION));
    }

    private Color getRandomColor() {
        return (new Color(random.nextInt(256),
            random.nextInt(256), random.nextInt(256)));
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new LocationExample().displayGUI();
            }
        };
        EventQueue.invokeLater(runnable);
    }
}