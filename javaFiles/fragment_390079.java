import javax.swing.*;

public class ProgressBarMinValue {
   private static void createAndShowGui() {
      JProgressBar progressBar = new JProgressBar();

      int value = 234;
      int denominator = 400;
      int minValue = 200;
      progressBar.setString(value + "/" + denominator);
      progressBar.setMinimum(minValue);
      System.out.println("value := " + value);

      progressBar.setValue(value);  // (A)

      progressBar.setMaximum(denominator);

      // progressBar.setValue(value);  // (B)

      JPanel mainPanel = new JPanel();
      mainPanel.add(progressBar);

      JOptionPane.showMessageDialog(null, mainPanel);
      System.out.println("progressBar.getValue() := " + progressBar.getValue());
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}