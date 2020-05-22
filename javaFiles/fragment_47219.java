import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;

public class CaptureScreen implements ActionListener {

    private JFrame f = new JFrame("Screen Capture");
    private JPanel pane = new JPanel();
    private JButton capture = new JButton("Capture");
    private JDialog d = new JDialog();
    private JScrollPane scrollPane = new JScrollPane();
    private JLabel l = new JLabel();
    private Point location;
    private Timer timer1;

    public CaptureScreen() {
        capture.setActionCommand("CaptureScreen");
        capture.setFocusPainted(false);
        capture.addActionListener(this);
        capture.setPreferredSize(new Dimension(300, 50));
        pane.add(capture);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(pane);
        f.setLocation(100, 100);
        f.pack();
        f.setVisible(true);
        createPicContainer();
        startTimer();
    }

    private void createPicContainer() {
        l.setPreferredSize(new Dimension(700, 500));
        scrollPane = new JScrollPane(l,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBackground(Color.white);
        scrollPane.getViewport().setBackground(Color.white);
        d.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        d.add(scrollPane);
        d.pack();
        d.setVisible(false);
        d.addWindowListener(new WindowListener() {

            public void windowOpened(WindowEvent e) {
            }

            public void windowClosing(WindowEvent e) {
                f.setVisible(true);
            }

            public void windowClosed(WindowEvent e) {
            }

            public void windowIconified(WindowEvent e) {
            }

            public void windowDeiconified(WindowEvent e) {
            }

            public void windowActivated(WindowEvent e) {
            }

            public void windowDeactivated(WindowEvent e) {
            }
        });
    }

    private void startTimer() {
        timer1 = new Timer(1000, new AbstractAction() {

            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        capture.doClick();
                        f.setVisible(false);
                    }
                });
            }
        });
        timer1.setDelay(500);
        timer1.setRepeats(false);
        timer1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("CaptureScreen")) {
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); // gets the screen size
            Robot r;
            BufferedImage bI;
            try {
                r = new Robot(); // creates robot not sure exactly how it works
                Thread.sleep(1000); // waits 1 second before capture
                bI = r.createScreenCapture(new Rectangle(dim)); // tells robot to capture the screen
                showPic(bI);
                saveImage(bI);
            } catch (AWTException e1) {
                e1.printStackTrace();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void saveImage(BufferedImage bI) {
        try {
            ImageIO.write(bI, "JPG", new File("screenShot.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPic(BufferedImage bI) {
        ImageIcon pic = new ImageIcon(bI);
        l.setIcon(pic);
        l.revalidate();
        l.repaint();
        d.setVisible(false);
        //location = f.getLocationOnScreen();
        //int x = location.x;
        //int y = location.y;
        //d.setLocation(x, y + f.getHeight());
        d.setLocation(150, 150);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                d.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                CaptureScreen cs = new CaptureScreen();
            }
        });
    }
}