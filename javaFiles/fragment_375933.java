import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

@SuppressWarnings("serial")
public class NimbusFoo extends JPanel {
   private JProgressBar progressBar = new JProgressBar();

   public NimbusFoo() {
      progressBar.setStringPainted(true);
      add(progressBar);
      add(new JButton(new StartAction("Start", KeyEvent.VK_S)));
   }

   private class StartAction extends AbstractAction {
      public StartAction(String name, int mnemonic) {
         super(name);
         putValue(MNEMONIC_KEY, mnemonic);
      }

      public void actionPerformed(java.awt.event.ActionEvent evt) {
         final JButton btn = (JButton) evt.getSource();
         btn.setEnabled(false);

         final SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>() {
            Random random = new Random();
            private long sleepTime = 200;
            protected Void doInBackground() throws Exception {
               int progress = 0;
               setProgress(progress);

               while (progress < 100) {
                  progress += random.nextInt(5);
                  progress = Math.min(100, progress);
                  setProgress(progress);
                  Thread.sleep(sleepTime);
               }
               return null;
            };
         };
         mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent pcEvt) {
               if ("progress".equals(pcEvt.getPropertyName())) {
                  progressBar.setValue(mySwingWorker.getProgress());
                  progressBar.setString(mySwingWorker.getProgress() + "%");
               }
               if ("state".equals(pcEvt.getPropertyName())) {
                  if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
                     btn.setEnabled(true);
                  }
               }
            }
         });
         mySwingWorker.execute();
      };
   }

   private static void createAndShowGui() {

      try {
         for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
               UIManager.setLookAndFeel(info.getClassName());
               break;
            }
         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (InstantiationException e) {
         e.printStackTrace();
      } catch (IllegalAccessException e) {
         e.printStackTrace();
      } catch (UnsupportedLookAndFeelException e) {
         e.printStackTrace();
      }

      NimbusFoo mainPanel = new NimbusFoo();

      JFrame frame = new JFrame("Nimbus Fun");
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