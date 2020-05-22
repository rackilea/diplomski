import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.*;

public class GapExample {
   private static final int M = 5;
   private static final int N = 6;
   private static final int PREF_W = 700;
   private static final int PREF_H = 500;

   @SuppressWarnings("serial")
   private static void createAndShowGui() {

      // *** attempt 1: set preferredSize of the mainPanel JPanel ***
      JPanel mainPanel = new JPanel(new GridLayout(M, N));
      mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
      mainPanel.setPreferredSize(new Dimension(PREF_W, PREF_H));

      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            String text = String.format("Foo [%d, %d]", i, j);
            JLabel label = new JLabel(text, SwingConstants.CENTER);
            label.setBorder(BorderFactory.createLineBorder(Color.blue));
            mainPanel.add(label);
         }
      }
      JOptionPane.showMessageDialog(null, mainPanel,
            "Attempt 1, setPreferredSize of mainPane",
            JOptionPane.PLAIN_MESSAGE);

      // *** attempt 2: override the getPreferredSize of the JLabel cells in the
      // grid ***
      mainPanel = new JPanel(new GridLayout(M, N));
      mainPanel.setBorder(BorderFactory.createLineBorder(Color.red));
      final Dimension labelPrefSize = new Dimension(PREF_W / N, PREF_H / M);
      for (int i = 0; i < M; i++) {
         for (int j = 0; j < N; j++) {
            String text = String.format("Foo [%d, %d]", i, j);
            JLabel label = new JLabel(text, SwingConstants.CENTER) {
               @Override
               public Dimension getPreferredSize() {
                  return labelPrefSize;
               }
            };
            label.setBorder(BorderFactory.createLineBorder(Color.blue));
            mainPanel.add(label);
         }
      }
      JOptionPane
            .showMessageDialog(null, mainPanel,
                  "Attempt 2, override getPreferredSize of the JLabel cells in the grid",
                  JOptionPane.PLAIN_MESSAGE);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}