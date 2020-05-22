import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.event.SwingPropertyChangeSupport;

public class MvcSscce {
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               createGUI();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   public static void createGUI() {
      GUImodel model = new GUImodel();

      GUIcontroller controller = new GUIcontroller();
      controller.addModel(model);

      GUIview view = new GUIview(controller);

      view.setVisible(true);
   }
}

class GUIview {
   private JPanel mainPanel = new JPanel();
   private JFrame frame = new JFrame("Fubar");

   public GUIview(AbstractController controller) {
      mainPanel.add(new JButton(controller.getButtonAction()));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationRelativeTo(null);
   }

   public void setVisible(boolean visible) {
      frame.setVisible(visible);
   }
}

abstract class AbstractModel {
   // note this should be a SwingPropertyChangeSupport
   public SwingPropertyChangeSupport propertyChangeSupport;

   public abstract void run();

   public AbstractModel() {
      propertyChangeSupport = new SwingPropertyChangeSupport(this);
   }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
      propertyChangeSupport.addPropertyChangeListener(listener);
   }

   public void removePropertyChangeListener(PropertyChangeListener listener) {
      propertyChangeSupport.removePropertyChangeListener(listener);
   }

   protected void firePropertyChange(String propertyName, Object oldValue,
         Object newValue) {
      propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
   }
}

class GUImodel extends AbstractModel {
   private boolean done = false;

   public void run() {
      done = false;
      final BackgroundThread myThread = new BackgroundThread();
      myThread.execute();
   }

   private class BackgroundThread extends SwingWorker<Void, Void> {
      private static final long SLEEP_TIME = 2000;

      @Override
      protected Void doInBackground() throws Exception {
         Thread.sleep(SLEEP_TIME);
         return null;
      }

      @Override
      protected void done() {
         System.out.println("done() called");
         boolean oldValue = done;
         done = true;

         // fire both property change listeners and see what gets notified
         firePropertyChange(GUIcontroller.DONE_PROPERTY, oldValue, done);
         GUImodel.this.firePropertyChange(GUIcontroller.DONE_PROPERTY_2,
               oldValue, done);
      }
   }
}

class AbstractController implements PropertyChangeListener {

   private AbstractModel model;

   public void addModel(AbstractModel model) {
      this.model = model;
      model.addPropertyChangeListener(this);
   }

   public Action getButtonAction() {
      @SuppressWarnings("serial")
      Action buttonAction = new AbstractAction("Press Me") {

         @Override
         public void actionPerformed(ActionEvent arg0) {
            model.run();
         }
      };
      return buttonAction;
   }

   @Override
   public void propertyChange(PropertyChangeEvent evt) {
      String output = String.format("Evt: %s, newValue: %s",
            evt.getPropertyName(), evt.getNewValue());
      System.out.println(output);
   }
}

class GUIcontroller extends AbstractController {

   public static final String DONE_PROPERTY_2 = "done property 2";
   public static final String DONE_PROPERTY = "done property";

}