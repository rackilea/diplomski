import java.awt.Dimension;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class SwingWorkerEg {
   public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {

            // first set everything up

            final MainFrame mainFrame = new MainFrame();
            final SomeDialog someDialog = new SomeDialog(mainFrame);

            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.pack();
            mainFrame.setLocationRelativeTo(null);
            someDialog.pack();
            someDialog.setLocationRelativeTo(null);

            // create SwingWorker and its PropertyChangeListener
            ImageLoadingWorker ilw = new ImageLoadingWorker();
            ilw.addPropertyChangeListener(new PropertyChangeListener() {

               @Override
               public void propertyChange(PropertyChangeEvent pcEvt) {
                  // since SwingWorker.StateValue is an enum, can use ==
                  if (SwingWorker.StateValue.DONE == pcEvt.getNewValue()) {

                     // when *done*, get rid of dialog, and show main JFrame

                     someDialog.setVisible(false);
                     mainFrame.setVisible(true);
                  }
               }
            });

            // first start SwingWorker
            ilw.execute();

            // And only *after* starting the SW, show the modal dialog
            someDialog.setVisible(true);
         }
      });
   }
}

class ImageLoadingWorker extends SwingWorker<Void, Void> {
   private static final long SLEEP_TIME = 5 * 1000;

   @Override
   protected Void doInBackground() throws Exception {
      // simulate long-running process
      Thread.sleep(SLEEP_TIME);
      return null;
   }
}

// bad example -- shouldn't extend JDialog!
class SomeDialog extends JDialog {
   private static final int PREF_W = 300;
   private static final int PREF_H = 60;

   public SomeDialog(JFrame frame) {
      super(frame, "Some Dialog", ModalityType.APPLICATION_MODAL);
      JProgressBar progressBar = new JProgressBar();
      progressBar.setIndeterminate(true);
      add(progressBar);
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}

// bad example -- shouldn't extend JFrame!
class MainFrame extends JFrame {
   private static final int PREF_W = 400;
   private static final int PREF_H = PREF_W;

   public MainFrame() {
      super("Main Frame");
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }
}