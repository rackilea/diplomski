import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings("serial")
public class PulsingButton extends JPanel {
   private static final int MAX_ALPHAS = 60;
   private float alpha = 1.0f;
   private JSpinner beatsPerMinSpinner = new JSpinner(new SpinnerNumberModel(60,  30, 120, 1));
   private JButton button = new JButton("Button") {
      @Override
      protected void paintComponent(Graphics g) {
         Graphics2D g2 = (Graphics2D) g;
         g2.setComposite(((AlphaComposite)g2.getComposite()).derive(alpha));
         super.paintComponent(g2);
      };
   };
   private float[] alphas = new float[MAX_ALPHAS];
   private Timer timer;

   public PulsingButton() {
      beatsPerMinSpinner.addChangeListener(new ChangeListener() {

         @Override
         public void stateChanged(ChangeEvent e) {
            int value = ((Integer) beatsPerMinSpinner.getValue()).intValue();
            setTimerDelay(value);
         }
      });

      add(new JLabel("Beats Per Minute:"));
      add(beatsPerMinSpinner);


      button.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            System.out.println("Hello!");
         }
      });
      add(button);
      for (int i = 0; i < alphas.length; i++) {
         double theta = (Math.PI * 2 * i) / alphas.length;
         alphas[i] = (float) ((Math.cos(theta) + 1) / 2.0);
      }

      int bpm = ((Integer) beatsPerMinSpinner.getValue()).intValue();
      timer = new Timer(setTimerDelay(bpm), new TimerListener());
      timer.start();

      System.out.println(setTimerDelay(bpm) + "");
   }

   private int setTimerDelay(int bpm) {
      int milisecondsInMinute = 60 * 1000;
      int delay = milisecondsInMinute / (bpm * alphas.length);
      if (timer != null) {
         timer.setDelay(delay);
      }
      return delay;
   }

   private class TimerListener implements ActionListener {
      int index = 0;

      @Override
      public void actionPerformed(ActionEvent arg0) {
         alpha = alphas[index];
         index++;
         index %= alphas.length;
         repaint();
      }
   }

   private static void createAndShowGui() {
      PulsingButton mainPanel = new PulsingButton();

      JFrame frame = new JFrame("PulsingButton");
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