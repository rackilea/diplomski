import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                        ex.printStackTrace();
                    }

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(new TestPane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public class TestPane extends JPanel {

        private Timeline timeline;

        private Map<Object, Image> mapImages = new HashMap<>(5);
        private List<Object> imageOrder = new ArrayList<>(5);

        public TestPane() throws IOException {
            BufferedImage[] images = new BufferedImage[]{
                ImageIO.read(new File("...")),
                ImageIO.read(new File("...")),
                ImageIO.read(new File("...")),
                ImageIO.read(new File("..."))
            };
            List<TimelineEvent> events = generateEvents(images, new ImageScaledObserver() {
                @Override
                public void imageScaled(Object id, Image image) {
                    if (!imageOrder.contains(id)) {
                        imageOrder.add(id);
                    }
                    mapImages.put(id, image);
                    repaint();
                }
            });

            timeline = new Timeline(events, 10000);
            Timer timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (timeline.update()) {
                        ((Timer) e.getSource()).stop();
                    }
                }
            });
            timer.setInitialDelay(5000);
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Object id : imageOrder) {
                Image image = mapImages.get(id);
                int x = (getWidth() - image.getWidth(this)) / 2;
                int y = (getHeight() - image.getHeight(this)) / 2;
                g2d.drawImage(image, x, y, this);
            }
            g2d.dispose();
        }

    }

    protected List<TimelineEvent> generateEvents(BufferedImage[] images, ImageScaledObserver observer) {
        double length = 1.0 / (double) (images.length);
        double overlap = length * 0.5;
        List<TimelineEvent> events = new ArrayList<>(images.length);
        double startAt = 0.0;
        for (BufferedImage image : images) {
            double endAt = Math.min(startAt + length + (overlap / 2.0), 1.0);
            events.add(new ScaleImageTimelineEvent(image, observer, startAt, endAt));
            startAt = Math.min(endAt - (overlap / 2.0), 1.0);
        }
        return events;
    }

    public interface TimelineEvent {

        public double[] range();

        public boolean isWithin(double timelineProgression);

        public void performAction(double timelineProgression);
    }

    public abstract class AbstractTimelineEvent implements TimelineEvent {

        private double from, to;

        public AbstractTimelineEvent(double from, double to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public double[] range() {
            return new double[]{from, to};
        }

        @Override
        public boolean isWithin(double timelineProgression) {
            boolean within = timelineProgression >= from && timelineProgression <= to;
            return within;
        }

        protected double localisedProgression(double timelineProgression) {
            double max = from - to;
            double value = timelineProgression - to;
            double weight = value / max;
            return 1d - weight;
        }

    }

    public interface ImageScaledObserver {

        public void imageScaled(Object id, Image img);
    }

    public class ScaleImageTimelineEvent extends AbstractTimelineEvent {

        private BufferedImage original;
        private ImageScaledObserver observer;
        private UUID id;

        public ScaleImageTimelineEvent(BufferedImage image, ImageScaledObserver observer, double from, double to) {
            super(from, to);
            this.original = image;
            this.observer = observer;
            this.id = UUID.randomUUID();
        }

        @Override
        public void performAction(double timelineProgression) {
            double progress = localisedProgression(timelineProgression);
            Image image = null;
            if (progress < 1.0) {
                int width = (int) (original.getWidth() * progress);
                if (width > 0) {
                    image = original.getScaledInstance((int) (original.getWidth() * progress), -1, Image.SCALE_FAST);
                }
            } else {
                image = original;
            }
            if (image != null) {
                observer.imageScaled(id, image);
            }
        }

    }

    public static class Timeline {

        private List<TimelineEvent> events;

        private Long startTime;
        private long duration;

        public Timeline(List<TimelineEvent> events, long duration) {
            this.events = events;
            this.duration = duration;
        }

        public List<TimelineEvent> getEvents() {
            return events;
        }

        public Long getStartTime() {
            return startTime;
        }

        public long getDuration() {
            return duration;
        }

        public void start() {
            if (startTime == null) {
                startTime = System.nanoTime();
            }
        }

        public void stop() {
            startTime = null;
        }

        public boolean update() {
            if (startTime == null) {
                start();
            }

            boolean completed = false;

            long currentTime = System.nanoTime();
            long diff = currentTime - getStartTime();

            long nanoDuration = TimeUnit.NANOSECONDS.convert(getDuration(), TimeUnit.MILLISECONDS);
            double progress = diff / (double) nanoDuration;
            if (progress > 1.0d) {
                progress = 1.0d;
                completed = true;
                stop();
            }

            for (TimelineEvent evt : getEvents()) {
                if (evt.isWithin(progress)) {
                    evt.performAction(progress);
                }
            }
            return completed;
        }
    }

}