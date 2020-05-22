import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static zoomboxwindow.ZoomBoxWindow.ZoomPane.ZOOM_AREA;

public class GlobalZoomBox {

  public static void main(String[] args) {
    new GlobalZoomBox();
  }

  public GlobalZoomBox() {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
          ex.printStackTrace();
        }
        Zoomer zoomer = new Zoomer();
        zoomer.setZoomWinodwVisible(true);
      }
    });
  }

  public class Zoomer extends JPanel {

    protected static final int ZOOM_AREA = 80;

    private JWindow popup;

    private BufferedImage buffer;
    private Robot bot;

    private float zoomLevel = 2f;
    private Point lastPoint;
    private final Timer timer;
    private final Timer popupTimer;

    public Zoomer() {
      popup = new JWindow();
      popup.setLayout(new BorderLayout());
      popup.add(this);
      popup.pack();
      try {
        bot = new Robot();
      } catch (AWTException ex) {
        ex.printStackTrace();
      }
      timer = new Timer(125, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          updateBuffer();
        }
      });
      timer.setCoalesce(true);
      timer.setInitialDelay(0);

      popupTimer = new Timer(250, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          if (lastPoint != null) {
            System.out.println("lastPoint = " + lastPoint);
            popup.setVisible(false);
            Point p = lastPoint;
            int x = p.x - (ZOOM_AREA / 2);
            int y = p.y - (ZOOM_AREA / 2);
            popup.setLocation(p.x + 16, p.y + 16);
            buffer = bot.createScreenCapture(new Rectangle(x, y, ZOOM_AREA, ZOOM_AREA));
            repaint();
            popup.setVisible(true);
          }
        }
      });
      popupTimer.setRepeats(false);
    }

    public void setZoomWinodwVisible(boolean value) {

      if (value && !popup.isVisible()) {

        timer.start();
        popup.setVisible(true);

      } else {

        timer.stop();
        popup.setVisible(false);

      }

    }

    @Override
    public Dimension getPreferredSize() {
      return new Dimension(Math.round(ZOOM_AREA * zoomLevel), Math.round(ZOOM_AREA * zoomLevel));
    }

    protected void updateBuffer() {
      if (bot != null) {
        PointerInfo info = MouseInfo.getPointerInfo();
        Point p = info.getLocation();
        if (lastPoint == null || !lastPoint.equals(p)) {
          lastPoint = p;
          popupTimer.stop();
          popup.setVisible(false);
        } else {
          if (!popup.isVisible()) {
            popupTimer.start();
          }
        }
      }
    }

    @Override
    protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2d = (Graphics2D) g.create();
      if (buffer != null) {
        AffineTransform at = g2d.getTransform();
        g2d.setTransform(AffineTransform.getScaleInstance(zoomLevel, zoomLevel));
        g2d.drawImage(buffer, 0, 0, this);
        g2d.setTransform(at);
      }
      g2d.setColor(Color.RED);
      g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
      g2d.dispose();
    }

  }

}