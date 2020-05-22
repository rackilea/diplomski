import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class ScrollTest {

    public static void main(String[] args) {
        new ScrollTest();
    }

    private JScrollPane scrollPane;
    private DesktopPane desktopPane;

    public ScrollTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                try {
                    desktopPane = new DesktopPane();
                    scrollPane = new JScrollPane(desktopPane);

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(scrollPane);
                    frame.setSize(desktopPane.getPreferredSize().width / 2, desktopPane.getPreferredSize().height / 2);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class DesktopPane extends JLayeredPane {

        private List<Point> points;

        public DesktopPane() throws IOException {
            points = new ArrayList<>(25);
            final BufferedImage img = ImageIO.read(new File("Desktop.jpg"));
            final JLabel desktop = new JLabel(new ImageIcon(img));
            final JPanel overlay = new JPanel() {

                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    int xOff = desktop.getX();
                    int yOff = desktop.getY();
                    int count = 0;
                    FontMetrics fm = g.getFontMetrics();
                    int height = fm.getHeight();
                    for (Point p : points) {
                        g.setColor(Color.RED);
                        String text = Integer.toString(++count);
                        int width = fm.stringWidth(text);
                        int radius = Math.max(width, height) + 5;
                        int x = xOff + p.x - radius / 2;
                        int y = yOff + p.y - radius / 2;
                        g.fillOval(x, y, radius, radius);
                        g.setColor(Color.WHITE);
                        x += (radius - width) / 2;
                        y += ((radius - height) / 2) + fm.getAscent();
                        g.drawString(text, x, y);
                    }
                }
            };
            overlay.setOpaque(false);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;

            add(desktop, gbc);
            add(overlay, gbc);

            setLayer(desktop, 0);
            setLayer(overlay, 5);

            overlay.setBorder(new LineBorder(Color.RED));

            Timer timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int x = (int) Math.round(Math.random() * img.getWidth());
                    int y = (int) Math.round(Math.random() * img.getHeight());
                    points.add(new Point(x, y));
                    repaint();

                    FontMetrics fm = getFontMetrics(overlay.getFont());
                    int height = fm.getHeight();
                    String text = Integer.toString(points.size() - 1);
                    int width = fm.stringWidth(text);
                    int radius = Math.max(width, height) + 5;

                    scrollRectToVisible(new Rectangle(x - radius / 2, y - radius / 2, radius, radius));
                }
            });
            timer.start();
        }
    }
}