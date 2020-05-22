import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class SwingWorkerEg extends JPanel {
   private static final int PREF_W = 300;
   private static final int PREF_H = 200;

   public SwingWorkerEg() {
      add(new JButton(new ButtonAction("Press Me")));
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("SwingWorkerEg");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new SwingWorkerEg());
      frame.pack();
      frame.setLocationRelativeTo(null);
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

class ButtonAction extends AbstractAction {
   public ButtonAction(String title) {
      super(title);
   }

   @Override
   public void actionPerformed(ActionEvent actEvt) {
      final JButton source = (JButton)actEvt.getSource();
      source.setEnabled(false);
      MySwingWorker mySw = new MySwingWorker();
      final MySplashScreen mySplash = new MySplashScreen();
      mySplash.setVisible(true);

      mySw.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if (SwingWorker.StateValue.DONE == pcEvt.getNewValue()) {
               mySplash.setVisible(false);
               mySplash.dispose();
               source.setEnabled(true);
            }
         }
      });
      mySw.execute();
   }
}

class MySwingWorker extends SwingWorker<Void, Void> {
   private static final long SLEEP_TIME = 5 * 1000;

   @Override
   protected Void doInBackground() throws Exception {
      Thread.sleep(SLEEP_TIME); // emulate long-running task
      return null;
   }
}

class MySplashScreen extends JWindow {
   private static final String LABEL_TEXT = "Loading, ... please wait...";
   private static final int PREF_W = 500;
   private static final int PREF_H = 300;

   public MySplashScreen() {
      add(new JLabel(LABEL_TEXT, SwingConstants.CENTER));
      pack();
      setLocationRelativeTo(null);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}