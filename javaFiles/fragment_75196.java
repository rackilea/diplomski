import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class TextChangedFrame extends JPanel {

   public static final String STOPPED_EDITING = "No Longer Editing or Deleting";
   private static final String EDITING = "Editing";
   private static final String DELETING = "Deleting";
   private static final int TIMER_DELAY = 500;
   private static final int PREF_W = 400;
   private static final int PREF_H = 100;
   private JTextField textField = new JTextField("Put your text here");
   private JLabel label = new JLabel("You have written: ");
   private ActionListener timerListener = new TimerListener();
   private Timer writeDeleteTimer = new Timer(TIMER_DELAY, timerListener);

   public TextChangedFrame() {
      setLayout(new BorderLayout());
      add(textField, BorderLayout.CENTER);
      add(label, BorderLayout.SOUTH);
      textField.getDocument().addDocumentListener(new DocumentListener() {

         public void insertUpdate(DocumentEvent e) {
            label.setText(EDITING);
            writeDeleteTimer.restart();
         }

         public void removeUpdate(DocumentEvent e) {
            label.setText(DELETING);
            writeDeleteTimer.restart();
         }

         public void changedUpdate(DocumentEvent e) {
         }
      });
   }

   @Override
   public Dimension getPreferredSize() {
      return new Dimension(PREF_W, PREF_H);
   }

   private class TimerListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent evt) {
         label.setText(STOPPED_EDITING);
         Timer timer = (Timer) evt.getSource();
         timer.stop();
      }
   }

   private static void createAndShowGui() {
      TextChangedFrame mainPanel = new TextChangedFrame();

      JFrame frame = new JFrame("TextChangedFrame");
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