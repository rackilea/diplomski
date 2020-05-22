import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class ProgExample extends JPanel {
   private JProgressBar progressBar = new JProgressBar(0, 100);

   public ProgExample() {
      progressBar.setBorderPainted(true);
      progressBar.setStringPainted(true);
      add(progressBar);
      add(new JButton(new ProgressAction1("Action 1", KeyEvent.VK_1, this)));
      add(new JButton(new ProgressAction2("Action 2", KeyEvent.VK_2, this)));
      add(new JButton(new ProgressAction3("Action 3", KeyEvent.VK_3, this)));
   }

   public void updateProgressBar(int value) {
      progressBar.setValue(value);
   }

   public void safeUpdateProgressBar(final int value) {
      if (SwingUtilities.isEventDispatchThread()) {
         updateProgressBar(value);
      } else {
         SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               updateProgressBar(value);
            }
         });
      }
   }

   private static void createAndShowGui() {
      ProgExample mainPanel = new ProgExample();

      JFrame frame = new JFrame("ProgExample");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

class ProgressAction1 extends AbstractAction {
   private static final int MAX_VALUE = 100;
   protected static final long SLEEP_TIME = 100;
   protected static final int STEP = 2;
   private ProgExample gui;

   public ProgressAction1(String name, int mnemonic, ProgExample gui) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      new Thread(new Runnable() {
         private int value = 0;
         @Override
         public void run() {
            while (value <= MAX_VALUE) {
               gui.safeUpdateProgressBar(value);
               value += STEP;
               try {
                  Thread.sleep(SLEEP_TIME);
               } catch (InterruptedException e) {}
            }
            gui.safeUpdateProgressBar(MAX_VALUE);
         }
      }).start();
   }
}

class ProgressAction2 extends AbstractAction {
   private static final int MAX_VALUE = 100;
   protected static final long SLEEP_TIME = 100;
   protected static final int STEP = 2;
   private ProgExample gui;

   public ProgressAction2(String name, int mnemonic, ProgExample gui) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      final SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
         private int value = 0;

         @Override
         protected Void doInBackground() throws Exception {
            while (value <= MAX_VALUE) {
               setProgress(value);
               value += STEP;
               try {
                  Thread.sleep(SLEEP_TIME);
               } catch (InterruptedException e) {}
            }
            setProgress(MAX_VALUE);
            return null;
         }
      };
      worker.addPropertyChangeListener(new PropertyChangeListener() {

         @Override
         public void propertyChange(PropertyChangeEvent pcEvt) {
            if ("progress".equals(pcEvt.getPropertyName())) {
               gui.updateProgressBar(worker.getProgress());
            }
         }
      });
      worker.execute();
   }
}

class ProgressAction3 extends AbstractAction {
   private static final int MAX_VALUE = 100;
   protected static final int SLEEP_TIME = 100;
   protected static final int STEP = 2;
   private ProgExample gui;

   public ProgressAction3(String name, int mnemonic, ProgExample gui) {
      super(name);
      putValue(MNEMONIC_KEY, mnemonic);
      this.gui = gui;
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      new Timer(SLEEP_TIME, new ActionListener() {
         int value = 0;

         @Override
         public void actionPerformed(ActionEvent e) {
            if (value <= MAX_VALUE) {
               gui.updateProgressBar(value);
               value += STEP;
            } else {
               gui.updateProgressBar(MAX_VALUE);
               ((Timer) e.getSource()).stop();
            }

         }
      }).start();
   }
}