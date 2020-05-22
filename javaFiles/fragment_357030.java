import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

@SuppressWarnings("serial")
public class SwingWorkerEg extends JPanel {
   private static final int PREF_W = 600;
   private static final int PREF_H = 400;
   private JLabel displayedLabel = new JLabel();

   public SwingWorkerEg() {
      setLayout(new BorderLayout());
      add(displayedLabel);
      try {
         MySwingWorker mySwingWorker = new MySwingWorker();
         mySwingWorker.execute();
      } catch (AWTException e) {
         e.printStackTrace();
      }
   }

   public void setLabelIcon(Icon icon) {
      displayedLabel.setIcon(icon);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class MySwingWorker extends SwingWorker<Void, Icon> {
      private final Rectangle SCREEN_RECT = new Rectangle(0, 0, PREF_W,
            PREF_H);
      private Robot robot = null;

      public MySwingWorker() throws AWTException {
         robot = new Robot();
      }

      @Override
      protected Void doInBackground() throws Exception {
         Timer utilTimer = new Timer();
         TimerTask task = new TimerTask() {

            @Override
            public void run() {
               BufferedImage capturedImage = captureScreen();
               publish(new ImageIcon(capturedImage));
            }

         };
         long delay = 200;
         utilTimer.scheduleAtFixedRate(task, delay, delay);
         return null;
      }

      @Override
      protected void process(List<Icon> chunks) {
         for (Icon icon : chunks) {
            setLabelIcon(icon);
         }
      }

      private BufferedImage captureScreen() {
         BufferedImage img = robot.createScreenCapture(SCREEN_RECT);
         return img;
      }

   }

   private static void createAndShowGui() {
      SwingWorkerEg mainPanel = new SwingWorkerEg();

      JFrame frame = new JFrame("SwingWorker Eg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
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