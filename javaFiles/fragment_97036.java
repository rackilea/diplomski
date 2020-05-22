import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainFrame extends JPanel {

    MainFrame() {
//      setOpaque(false);
        setBackground(Color.WHITE);
        MouseListener ml = new MouseListener();
        addMouseListener(ml);
        addMouseMotionListener(ml);

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

            @Override
            public void eventDispatched(AWTEvent event) {
                MouseEvent evt = (MouseEvent) event;
                Point p = evt.getPoint();
                if (evt.getSource() != MainFrame.this) {
                    p = SwingUtilities.convertPoint(evt.getComponent(), p, MainFrame.this);
                }
                if (MainFrame.this.getBounds().contains(p)) {
                    System.out.println(p.x + "x" + p.y);
                }
            }
        }, AWTEvent.MOUSE_MOTION_EVENT_MASK);

        Timer timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PointerInfo pi = MouseInfo.getPointerInfo();
                Point p = pi.getLocation();
                SwingUtilities.convertPointFromScreen(p, MainFrame.this);
                if (MainFrame.this.getBounds().contains(p)) {
                    System.out.println("pi = " + p.x + "x" + p.y);
                }
            }
        });
        timer.start();
    }

    private class MouseListener extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
//          System.out.println("Mouse clicked");
            DisplayFrame.showDisplay(e.getX(), e.getY());
        }

        public void mousePressed(MouseEvent e) {
//          DisplayFrame.showDisplay(e.getX(), e.getY());
        }

        public void mouseReleased(MouseEvent e) {
//          DisplayFrame.showDisplay(e.getX(), e.getY());
        }

        public void mouseEntered(MouseEvent e) {
//          DisplayFrame.showDisplay(e.getX(), e.getY());
        }

        public void mouseExited(MouseEvent e) {
            DisplayFrame.getInstance().setVisible(false);
        }

        public void mouseDragged(MouseEvent e) {
            // TODO Auto-generated method stub
        }

        public void mouseMoved(MouseEvent e) {
            System.out.println("Mouse moved " + e.getX() + "x" + e.getY());
            DisplayFrame.showDisplay(e.getX(), e.getY());
        }
    }

    private static MainFrame mainFrame;

    public static MainFrame getInstance() {
        if (mainFrame == null) {
            mainFrame = new MainFrame();
            mainFrame.setLayout(new GridBagLayout());

            JPanel blocker = new JPanel();
            blocker.setBackground(Color.RED);
            blocker.setPreferredSize(new Dimension(200, 200));
            MouseAdapter ma = new MouseAdapter() {
            };
            blocker.addMouseListener(ma);
            blocker.addMouseMotionListener(ma);
            mainFrame.add(blocker);

            Dimension size = new Dimension(900, 700);
            mainFrame.setPreferredSize(size);
            mainFrame.setMinimumSize(size);
        }

        return mainFrame;
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

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(getInstance(), BorderLayout.CENTER);
                frame.pack();

                frame.setVisible(true);
            }
        });
    }

    static class DisplayFrame extends JFrame {

        public static DisplayFrame display;

        DisplayFrame() {
            setUndecorated(true);
            JPanel panel1 = new JPanel();
            panel1.setBackground(Color.BLACK);
            JPanel panel2 = new JPanel();
            panel2.setBackground(Color.WHITE);
            JTabbedPane tPane = new JTabbedPane();
            tPane.setTabPlacement(JTabbedPane.BOTTOM);
            tPane.addTab("Black", panel1);
            tPane.addTab("White", panel2);
            add(tPane);
        }

        public static DisplayFrame getInstance() {
            if (display == null) {
                display = new DisplayFrame();
            }

            // Set size
            Dimension size = new Dimension(200, 200);
            display.setPreferredSize(size);
            display.setMinimumSize(size);
            display.setMaximumSize(size);

            return display;
        }

        public static void showDisplay(int x, int y) {
            getInstance();

            int compX = (int) MainFrame.getInstance().getLocationOnScreen().getX();
            int compY = (int) MainFrame.getInstance().getLocationOnScreen().getY();
            // Should be the location 10 pixels to the right and 20 pixels below the cursor             
            int newX = compX + x + 10;
            int newY = compY + y + 20;

            // Set location
            display.setLocation(newX, newY);

            if (!display.isVisible()) {
                display.setVisible(true);
            }
            // This is to make sure the frame doesn't get hidden behind the main window     
            display.toFront();

        } // end method 
    }
}