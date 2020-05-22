import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Rec extends JComponent {

    public ArrayList<Rectangle> rectanglesList = new ArrayList<Rectangle>();
    public int arrx[] = new int[120];
    public int arry[] = new int[120];
    JFrame frame = new JFrame();
    public int xSize = 2000;
    public int ySize = 1000;
    public int x;
    public int y;
    public int pickedPanelNum = 0;
    public String pickedPanelDash = "";
    public String pickedPanelColor = "";
    Color bColor = Color.BLACK;
    Color wColor = Color.WHITE;
    boolean removedPanel = false;

    public void launchFrame() {
        Random rand = new Random();
        for (int x = 0; x < 10; x++) {
            arrx[x] = rand.nextInt(640);
            arry[x] = rand.nextInt(590);
            rectanglesList.add(new Rectangle(arrx[x], arry[x], 80, 90));
        }

        JPanel mainPanel = new JPanel();

        JPanel panelsPane = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

//              Image img = Toolkit.getDefaultToolkit().getImage(Rectangles2.class.getResource("background.jpg"));
//              g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
                Graphics2D g2 = (Graphics2D) g;

                for (Rectangle s : rectanglesList) {
                    g2.setColor(bColor);
                    g2.fill(s);
                    g2.setColor(wColor);
                    g2.draw(s);
                }
            }
        };

        JPanel rightPane = new JPanel();

        panelsPane.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent event) {
                x = event.getX();
                y = event.getY();
            }

            public void mouseReleased(MouseEvent event) {
                // Because the rectangles are painted in order, the later
                // rectangles are painted over the eailer ones, so, we reverse
                // the list so we can check for the higher positioned
                // rectangles
                List<Rectangle> copy = new ArrayList<>(rectanglesList);
                Collections.reverse(copy);
                for (Rectangle r : copy) {
                    if (r.contains(event.getPoint())) {
                        rectanglesList.remove(r);
                        break;
                    }
                }
                event.getComponent().repaint();
            }
        });

        panelsPane.addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent event) {
            }

            public void mouseReleased(MouseEvent event) {
            }

            public void mouseClicked(MouseEvent event) {
            }

            public void mouseEntered(MouseEvent event) {
            }

            public void mouseExited(MouseEvent event) {
            }
        });

        panelsPane.setPreferredSize(new Dimension(800, ySize - 315));
        rightPane.setPreferredSize(new Dimension(530, ySize - 315));
        mainPanel.setPreferredSize(new Dimension(xSize, ySize));
        frame.setPreferredSize(new Dimension(xSize, ySize));
        rightPane.setBackground(Color.gray);
        mainPanel.add(panelsPane);
        mainPanel.add(rightPane);
        frame.add(mainPanel);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Rec obj = new Rec();
                obj.launchFrame();
            }
        });
    }
}