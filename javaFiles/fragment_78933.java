import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class Gravity implements Runnable {
   public static final String ALTITUDE = "altitude";
   private SwingPropertyChangeSupport swingPcSupport = new SwingPropertyChangeSupport(this);
   private volatile double altitude;

   @Override
   public void run() {
      while (true) {
         double temp = altitude + 10;
         setAltitude(temp); // fires the listeners
         try {
            Thread.sleep(10);
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