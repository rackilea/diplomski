import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TiedSpinnerChangeListeners extends JPanel {
   public static final int SPINNER_RATIO = 5;
   public static final int SPINNER_1_MAX = 100;
   public static final int SPINNER_2_MAX = SPINNER_1_MAX * SPINNER_RATIO;
   private JSpinner spinner1 = new JSpinner(new SpinnerNumberModel(0, 0,
         SPINNER_1_MAX, 1));
   private JSpinner spinner2 = new JSpinner(new SpinnerNumberModel(0, 0,
         SPINNER_2_MAX, SPINNER_RATIO));

   public TiedSpinnerChangeListeners() {
      add(spinner1);
      add(spinner2);

      TiedSpinnerListener spinnerListener1 = new TiedSpinnerListener(spinner2, false);
      TiedSpinnerListener spinnerListener2 = new TiedSpinnerListener(spinner1, true);
      spinnerListener1.setSecondSpinnerListener(spinnerListener2);
      spinnerListener2.setSecondSpinnerListener(spinnerListener1);
      spinner1.addChangeListener(spinnerListener1);
      spinner2.addChangeListener(spinnerListener2);


   }

   private static void createAndShowGui() {
      JFrame frame = new JFrame("GUI");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new TiedSpinnerChangeListeners());
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

class TiedSpinnerListener implements ChangeListener {
   private TiedSpinnerListener secondSpinnerListener;
   private JSpinner secondSpinner;
   private boolean listenerOn = true;
   private boolean largerValue;

   public TiedSpinnerListener(JSpinner secondSpinner,
         boolean largerValue) {
      this.secondSpinner = secondSpinner;
      this.largerValue = largerValue;
   }

   @Override
   public void stateChanged(ChangeEvent e) {
      if (!listenerOn) {
         return;
      }
      secondSpinnerListener.setListenerOn(false);
      int value = ((Integer) ((JSpinner) e.getSource()).getValue()).intValue();

      int newValue = largerValue ? value
            / TiedSpinnerChangeListeners.SPINNER_RATIO : value
            * TiedSpinnerChangeListeners.SPINNER_RATIO;
      secondSpinner.setValue(newValue);
      secondSpinnerListener.setListenerOn(true);
   }

   public void setSecondSpinnerListener(TiedSpinnerListener secondSpinnerListener) {
      this.secondSpinnerListener = secondSpinnerListener;
   }

   public boolean isListenerOn() {
      return listenerOn;
   }

   public void setListenerOn(boolean listenerOn) {
      this.listenerOn = listenerOn;
   }

}