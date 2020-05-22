import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PaintModel {

    public static void main(String[] args) {
        new PaintModel();
    }

    public PaintModel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                MutableModel model = new DefaultModel();
                Controller controller = new Controller(model);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new View(model));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                controller.start();
            }
        });
    }

    public interface Model {

        public Rectangle getBounds();
        public Dimension getSize();
        public void addChangeListener(ChangeListener listener);
        public void removeChangeListener(ChangeListener listener);

    }

    public interface MutableModel extends Model {

        public void update();

    }

    public class DefaultModel implements MutableModel {

        private final Dimension size = new Dimension(200, 200);
        private final Rectangle bounds = new Rectangle(95, 95, 10, 10);

        private int xDelta = ((int) (Math.random() * 5)) + 1;
        private int yDelta = ((int) (Math.random() * 5)) + 1;

        private List<ChangeListener> changeListeners;

        public DefaultModel() {
            changeListeners = new ArrayList<>(25);
        }

        @Override
        public void addChangeListener(ChangeListener listener) {
            changeListeners.add(listener);
        }

        @Override
        public void removeChangeListener(ChangeListener listener) {
            changeListeners.remove(listener);
        }

        protected void fireStateChanged() {
            if (changeListeners.size() > 0) {
                ChangeEvent evt = new ChangeEvent(this);
                Iterator<ChangeListener> it = changeListeners.iterator();
                while (it.hasNext()) {
                    ChangeListener listener = it.next();
                    listener.stateChanged(evt);
                }
            }
        }

        @Override
        public Dimension getSize() {
            return size;
        }

        @Override
        public Rectangle getBounds() {
            return bounds;
        }

        @Override
        public void update() {
            bounds.x += xDelta;
            bounds.y += yDelta;
            if (bounds.x < 0) {
                bounds.x = 0;
                xDelta *= -1;
            } else if (bounds.x + bounds.width > size.width) {
                bounds.x = size.width - bounds.width;
                xDelta *= -1;
            }
            if (bounds.y < 0) {
                bounds.y = 0;
                yDelta *= -1;
            } else if (bounds.y + bounds.height > size.height) {
                bounds.y = size.height - bounds.height;
                yDelta *= -1;
            }
            fireStateChanged();
        }

    }

    public class Controller extends Thread {

        private MutableModel model;

        public Controller(MutableModel model) {
            this.model = model;
            setDaemon(true);
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException ex) {
                }
                model.update();
            }
        }

    }

    public class View extends JComponent implements ChangeListener {

        private Model model;

        public View(Model model) {
            this.model = model;
            this.model.addChangeListener(this);
            setBackground(Color.WHITE);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(model.getSize());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
            Rectangle bounds = model.getBounds();
            g2d.setColor(Color.BLUE);
            g2d.drawOval(bounds.x, bounds.y, bounds.width, bounds.height);
            g2d.dispose();
        }

        @Override
        public void stateChanged(ChangeEvent e) {
            repaint();
        }

    }

}