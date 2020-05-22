import java.awt.Dimension;
import java.awt.Window;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class Example2 extends JPanel {
   private static final int PREF_W = 400;
   private static final int PREF_H = 200;
   private JLabel label = new JLabel();

   public Example2() {
      add(label);
      final MySwingWorker mySwingWorker = new MySwingWorker();
      mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (MySwingWorker.STEP_PERFORMING.equals(pcEvt.getPropertyName())) {
               label.setText(mySwingWorker.getStepPerforming());
            } else if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
               Window win = SwingUtilities.getWindowAncestor(Example2.this);
               win.dispose();
            }
         }
      });
      mySwingWorker.execute();
   }

   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGUI() {
      Example2 example = new Example2();

      JFrame frame = new JFrame("Example 2");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(example);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGUI();
         }
      });
   }
}

class MySwingWorker extends SwingWorker<Void, Void> { 
   public static final String STEP_PERFORMING = "step performing";
   private static final long SLEEP_DELAY = 1500;
   private String stepPerforming = "";

   @Override
   protected Void doInBackground() throws Exception {
      start();
      createDir();
      linkList();
      download();
      unzip();
      deletezip();
      return null;
   }


   public String getStepPerforming() {
      return stepPerforming;
   }


   public void setStepPerforming(String stepPerforming) {
      String oldValue = this.stepPerforming;
      String newValue = stepPerforming;
      this.stepPerforming = stepPerforming;
      firePropertyChange(STEP_PERFORMING, oldValue, newValue);
   }

   private void start() {
      setStepPerforming("Starting...");
      // Start();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

   private void createDir() {
      setStepPerforming("Executing Create Directory");
      // CreateDir();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

   private void linkList() {
      setStepPerforming("Executing Link List");
      // LinkList();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

   private void download() {
      setStepPerforming("Executing Download");
      // Download();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

   private void unzip() {
      setStepPerforming("Executing Unzip");
      // unzip();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

   private void deletezip() {
      setStepPerforming("Executing Delete zip");
      // DeleteZip();
      try {
         Thread.sleep(SLEEP_DELAY);
      } catch (InterruptedException e) {}
   }

}