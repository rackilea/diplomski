import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.SwingPropertyChangeSupport;

public class GravityTestGui extends JPanel {
   private static final long ALT_SLEEP_TIME = 400;
   private static final double ALT_DELTA = 5;
   JLabel altitudeLabel = new JLabel("     ");
   private Gravity gravity = new Gravity(ALT_SLEEP_TIME, ALT_DELTA);

   public GravityTestGui() {
      add(new JLabel("Altitude:"));
      add(altitudeLabel);

      gravity.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (Gravity.ALTITUDE.equals(pcEvt.getPropertyName())) {
               String altText = String.valueOf(gravity.getAltitude());
               altitudeLabel.setText(altText);
            }
         }
      });

      new Thread(gravity).start();
   }

   private static void createAndShowGui() {
      GravityTestGui mainPanel = new GravityTestGui();

      JFrame frame = new JFrame("GravityTest");
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

class Gravity implements Runnable {
   public static final String ALTITUDE = "altitude";
   private SwingPropertyChangeSupport swingPcSupport = new SwingPropertyChangeSupport(this);
   private volatile double altitude;
   private long sleepTime;
   private double delta;

   public Gravity(long sleepTime, double delta) {
      this.sleepTime = sleepTime;
      this.delta = delta;
   }

   @Override
   public void run() {
      while (true) {
         double temp = altitude + delta;
         setAltitude(temp); // fires the listeners
         try {
            Thread.sleep(sleepTime);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }
      }

   }

   public double getAltitude() {
      return altitude;
   }

   public void setAltitude(double altitude) {
      Double oldValue = this.altitude;
      Double newValue = altitude;

      this.altitude = newValue;

      // this will be fired on the EDT since it is a SwingPropertyChangeSupport object
      swingPcSupport.firePropertyChange(ALTITUDE, oldValue, newValue);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      swingPcSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      swingPcSupport.removePropertyChangeListener(listener);
   }
}