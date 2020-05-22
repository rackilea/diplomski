import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

@SuppressWarnings("serial")
public class Mandel2 extends JPanel {
    private static final int GUI_HEIGHT = 600;
    private static final int GUI_WIDTH = 600;
    private static final int MAX_ITERS = 50000;
    private BufferedImage image = new BufferedImage(GUI_WIDTH, GUI_HEIGHT,
            BufferedImage.TYPE_INT_ARGB);
    private Rectangle zoomRect;
    private double myX0 = -2.5;
    private double myY0 = -2.0;
    private double myX1 = 1.5;
    private double myY1 = 2.0;
    private JDialog waitDialog;

    public Mandel2() {
        final MyMouse myMouse = new MyMouse();

        int delayStartingCalc = 2 * 1000; // 2 second delay
        Timer timer = new Timer(delayStartingCalc, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addMouseListener(myMouse);
                addMouseMotionListener(myMouse);

                Rectangle myRect = new Rectangle(0, 0, GUI_WIDTH, GUI_HEIGHT);
                createMandel(myRect);
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(GUI_WIDTH, GUI_HEIGHT);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
        Graphics2D g2 = (Graphics2D) g;
        if (zoomRect == null) {
            return;
        }
        g2.setXORMode(Color.gray);
        g2.draw(zoomRect);
    }

    private double screenToLogicalX(double screenX) {
        return myX0 + (screenX * (myX1 - myX0)) / GUI_WIDTH;
    }

    private double screenToLogicalY(double screenY) {
        return myY0 + ((GUI_HEIGHT - screenY) * (myY1 - myY0)) / GUI_HEIGHT;
    }

    private void createMandel(Rectangle myRect) {
        double x0 = screenToLogicalX(myRect.x);
        double y0 = screenToLogicalY(myRect.y + myRect.height);
        double x1 = screenToLogicalX(myRect.x + myRect.width);
        double y1 = screenToLogicalY(myRect.y);

        myX0 = x0;
        myY0 = y0;
        myX1 = x1;
        myY1 = y1;

        MandelWorker mandelWorker = new MandelWorker(MAX_ITERS, x0, y0, x1, y1);
        mandelWorker.addPropertyChangeListener(new MandelWorkerListener());
        mandelWorker.execute();
        if (waitDialog == null) {
            Window win = SwingUtilities.getWindowAncestor(Mandel2.this);
            JProgressBar jProgressBar = new JProgressBar();
            jProgressBar.setIndeterminate(true);
            waitDialog = new JDialog(win, "Please Wait", ModalityType.APPLICATION_MODAL);
            waitDialog.add(jProgressBar);
            waitDialog.pack();
            waitDialog.setLocationRelativeTo(win);
        }
        waitDialog.setVisible(true);
    }

    private class MyMouse extends MouseAdapter {
        private Point p;

        @Override
        public void mousePressed(MouseEvent e) {
            p = e.getPoint();
        }

        public void mouseDragged(MouseEvent e) {
            zoomRect = createRect(e);
            repaint();
        };

        @Override
        public void mouseReleased(MouseEvent e) {
            zoomRect = createRect(e);
            repaint();
            createMandel(zoomRect);
        }

        private Rectangle createRect(MouseEvent e) {
            int x = Math.min(p.x, e.getX());
            int y = Math.min(p.y, e.getY());
            int width = Math.abs(p.x - e.getX());
            int height = Math.abs(p.y - e.getY());
            return new Rectangle(x, y, width, height);
        }
    }

    private class MandelWorkerListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
                waitDialog.setVisible(false);
                waitDialog.dispose();
                MandelWorker worker = (MandelWorker) evt.getSource();
                try {
                    image = worker.get();
                    zoomRect = null;
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class MandelWorker extends SwingWorker<BufferedImage, Void> {
        private int maxIters;
        private double x1;
        private double y1;
        private double x2;
        private double y2;

        public MandelWorker(int maxIters, double x1, double y1, double x2, double y2) {
            this.maxIters = maxIters;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        protected BufferedImage doInBackground() throws Exception {
            int[][] iterGrid = new int[GUI_HEIGHT][GUI_WIDTH];
            for (int i = 0; i < GUI_HEIGHT; i++) {
                double y = y1 + i * (y2 - y1) / GUI_HEIGHT;
                for (int j = 0; j < GUI_WIDTH; j++) {
                    double x = x1 + j * (x2 - x1) / GUI_WIDTH;
                    int iIndex = GUI_HEIGHT - i - 1;
                    iterGrid[iIndex][j] = calcMandel(x, y);
                }
            }

            return render(iterGrid);
        }

        private BufferedImage render(int[][] iterGrid) {
            int w = GUI_WIDTH;
            int h = GUI_HEIGHT;
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = img.createGraphics();
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (iterGrid[i][j] < maxIters) {
                        String hexCode = String.format("#%06x", (0xFFFFFF & (32 * iterGrid[i][j])));
                        g2.setColor(Color.decode(hexCode));
                    } else {
                        g2.setColor(Color.CYAN);
                    }
                    g2.drawLine(j, i, j, i);
                }
            }
            g2.dispose();
            return img;
        }

        private int calcMandel(double x, double y) {
            Complex c = new Complex(x, y);
            Complex z = new Complex();
            int iters = 0;

            while (z.getMagnitude() < 2 && iters <= maxIters) {
                z = z.multiply(z).add(c);
                iters++;
            }
            return iters;
        }
    }

    private class Complex {
        private double real, imag;

        // Constructors
        public Complex() {
            real = 0.0;
            imag = 0.0;
        }

        public Complex(double real, double imag) {
            this.real = real;
            this.imag = imag;
        }

        // add given complex number to this one, returning the Complex result
        public Complex add(Complex other) {
            return new Complex(this.real + other.real, this.imag + other.imag);
        }

        // multiply given complex number by this one, returning the Complex
        // result
        public Complex multiply(Complex other) {
            return new Complex((this.real * other.real) - (this.imag * other.imag),
                    (this.imag * other.real) + (this.real * other.imag));
        }

        // get the magnitude of this complex number
        public double getMagnitude() {
            return Math.sqrt((real * real) + (imag * imag));
        }
    }

    private static void createAndShowGui() {
        Mandel2 mainPanel = new Mandel2();

        JFrame frame = new JFrame("Mandel2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.setResizable(false);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}